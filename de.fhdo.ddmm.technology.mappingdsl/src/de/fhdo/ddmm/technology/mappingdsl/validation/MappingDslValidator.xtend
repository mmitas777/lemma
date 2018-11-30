/*
 * generated by Xtext 2.12.0
 */
package de.fhdo.ddmm.technology.mappingdsl.validation

import org.eclipse.xtext.validation.Check
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping
import de.fhdo.ddmm.technology.mapping.MappingPackage
import de.fhdo.ddmm.technology.mapping.TechnologyMapping
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.service.ServicePackage
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.technology.CommunicationType
import java.util.List
import org.eclipse.emf.ecore.EObject
import com.google.common.base.Function
import org.eclipse.emf.ecore.EReference
import de.fhdo.ddmm.technology.mapping.InterfaceMapping
import de.fhdo.ddmm.technology.mapping.OperationMapping
import de.fhdo.ddmm.technology.mapping.ReferredOperationMapping
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification
import de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint
import java.util.Map
import de.fhdo.ddmm.technology.mapping.PrimitiveParameterMapping
import de.fhdo.ddmm.typechecking.TypeChecker
import de.fhdo.ddmm.typechecking.TypesNotCompatibleException
import de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType
import de.fhdo.ddmm.data.PrimitiveType
import de.fhdo.ddmm.technology.mapping.ComplexParameterMapping
import de.fhdo.ddmm.data.Type
import de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping
import de.fhdo.ddmm.data.ComplexType
import org.eclipse.emf.ecore.EStructuralFeature
import de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.technology.Technology

/**
 * This class contains validation rules for the Mapping DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class MappingDslValidator extends AbstractMappingDslValidator {
    /**
     * Check that imported file is imported exactly once
     */
    @Check
    def checkImportFileUniqueness(TechnologyMapping model) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(model.imports, [importURI])
        if (duplicateIndex === -1) {
            return
        }

        val duplicate = model.imports.get(duplicateIndex)
        error("File is already being imported", duplicate,
            ServicePackage::Literals.IMPORT__IMPORT_URI)
    }

    /**
     * Check that technology is assigned only once to a microservice mapping
     */
    @Check
    def checkTechnologyUniqueness(MicroserviceMapping mapping) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(mapping.technologies, [it])
        if (duplicateIndex > -1) {
            error('''Duplicate technology assignment''',
                MappingPackage::Literals.MICROSERVICE_MAPPING__TECHNOLOGIES, duplicateIndex)
        }
    }

    /**
     * Check that only one annotated technology contains type definitions
     */
    @Check
    def checkUniqueTypeDefinitionTechnology(MicroserviceMapping mapping) {
        var String typeDefinitionTechnologyName = null
        for (i : 0..<mapping.technologies.size) {
            val technologyImport = mapping.technologies.get(i)
            val technologyModel = DdmmUtils.getImportedModelRoot(technologyImport.eResource,
                technologyImport.importURI, Technology)
            if (!technologyModel.primitiveTypes.empty ||
                !technologyModel.listTypes.empty ||
                !technologyModel.dataStructures.empty) {
                if (typeDefinitionTechnologyName === null)
                    typeDefinitionTechnologyName = technologyModel.name
                else
                    error('''Technology "«typeDefinitionTechnologyName»" already defines ''' +
                        '''technology-specific types. Only one technology per microservice may ''' +
                        '''define technology-specific types.''',
                        MappingPackage::Literals.MICROSERVICE_MAPPING__TECHNOLOGIES, i)
            }
        }
    }

    /**
     * Check that annotated technologies define not only deployment-related concepts
     */
    @Check
    def checkTechnologiesForServiceConcepts(MicroserviceMapping mapping) {
        for (i : 0..<mapping.technologies.size) {
            val technologyImport = mapping.technologies.get(i)
            val technologyModel = DdmmUtils.getImportedModelRoot(technologyImport.eResource,
                technologyImport.importURI, Technology)
            if (technologyModel.primitiveTypes.empty &&
                technologyModel.protocols.empty &&
                technologyModel.serviceAspects.empty) {
                error("Technology does not specify service-related concepts",
                    MappingPackage::Literals.MICROSERVICE_MAPPING__TECHNOLOGIES, i)
            }
        }
    }

    /**
     * Check technologies of a microservice mapping per communication type for unambiguous default
     * protocols
     */
    @Check
    def checkTechnologiesForUniqueDefaultProtocols(MicroserviceMapping mapping) {
        if (mapping.technologies.empty) {
            return
        }

        val nonUniqueCommunicationTypes = CommunicationType.values
            .filter[communicationType |
                !mapping.protocols.exists[communicationType === it.communicationType]
            ]
            .filter[!isDefaultProtocolUnique(mapping, it)]

        for (communicationType : nonUniqueCommunicationTypes) {
            val String typeString = switch (communicationType) {
                case CommunicationType.ASYNCHRONOUS: "asynchronous"
                case CommunicationType.SYNCHRONOUS: "synchronous"
            }
            error('''Ambiguous default protocol for «typeString» communication. The ''' +
                '''mapping needs to explicitly specifiy a protocol for «typeString» ''' +
                '''communication.''', mapping,
                MappingPackage::Literals.MICROSERVICE_MAPPING__MICROSERVICE)
        }
    }

    /**
     * Helper to check if default protocol of a microservice mapping is unique for a given
     * communication type
     */
    private def isDefaultProtocolUnique(MicroserviceMapping mapping,
        CommunicationType communicationType) {
        var boolean alreadyFoundDefaultProtocolForCommunicationType
        for (technologyImport : mapping.technologies) {
            val technologyModel = DdmmUtils.getImportedModelRoot(technologyImport.eResource,
                technologyImport.importURI, Technology)
            val hasDefaultProtocolForCommunicationType = technologyModel.protocols.exists[
                ^default && it.communicationType === communicationType
            ]
            if (hasDefaultProtocolForCommunicationType) {
                if (alreadyFoundDefaultProtocolForCommunicationType)
                    return false
                else
                    alreadyFoundDefaultProtocolForCommunicationType = true
            }
        }

        return true
    }

    /**
     * Check that service mappings are unique
     */
    @Check
    def checkMappingUniqueness(TechnologyMapping model) {
        // Mapping technologies may be empty if the model contains syntax errors
        val modelMappingsWithTechnology = model.mappings
            .filter[!technologies.empty]
            .toList

        checkMappingUniqueness(modelMappingsWithTechnology, "Service", [
                val qualifiedNameSegments = <String> newArrayList
                qualifiedNameSegments.addAll(microservice.microservice.qualifiedNameParts)
                QualifiedName.create(qualifiedNameSegments).toString
            ], MappingPackage::Literals.MICROSERVICE_MAPPING__MICROSERVICE
        )
    }

    /**
     * Check that interface mappings are unique
     */
    @Check
    def checkInterfaceMappingUniqueness(MicroserviceMapping microserviceMapping) {
        checkMappingUniqueness(microserviceMapping.interfaceMappings, "Interface",
            [QualifiedName.create(interface.qualifiedNameParts).toString],
            MappingPackage::Literals.INTERFACE_MAPPING__INTERFACE
        )
    }

    /**
     * Check that operation mappings are unique
     */
    @Check
    def checkOperationMappingUniqueness(MicroserviceMapping microserviceMapping) {
        checkMappingUniqueness(microserviceMapping.operationMappings, "Operation",
            [QualifiedName.create(operation.qualifiedNameParts).toString],
            MappingPackage::Literals.OPERATION_MAPPING__OPERATION
        )
    }

    /**
     * Check that referred operation mappings are unique
     */
    @Check
    def checkReferredOperationMappingUniqueness(MicroserviceMapping microserviceMapping) {
        checkMappingUniqueness(microserviceMapping.referredOperationMappings, "Referred operation",
            [QualifiedName.create(operation.qualifiedNameParts).toString],
            MappingPackage::Literals.REFERRED_OPERATION_MAPPING__OPERATION
        )
    }

    /**
     * Check that communication types and endpoint protocols of technology-specific protocol
     * specifications of a microservice mapping are unique
     */
    @Check
    def checkProtocolSpecificationCommunicationTypesUniqueness(
        MicroserviceMapping microserviceMapping) {
        checkCommunicationTypeUniqueness(microserviceMapping.protocols)
        checkEndpointProtocolUniqueness(microserviceMapping.endpoints)
    }

    /**
     * Check that communication types and endpoint protocols  of technology-specific protocol
     * specifications of an interface mapping are unique
     */
    @Check
    def checkProtocolSpecificationCommunicationTypesUniqueness(InterfaceMapping interfaceMapping) {
        checkCommunicationTypeUniqueness(interfaceMapping.protocols)
        checkEndpointProtocolUniqueness(interfaceMapping.endpoints)
    }

    /**
     * Check that communication types and endpoint protocols  of technology-specific protocol
     * specifications of an operation mapping are unique
     */
    @Check
    def checkProtocolSpecificationCommunicationTypesUniqueness(OperationMapping operationMapping) {
        checkCommunicationTypeUniqueness(operationMapping.protocols)
        checkEndpointProtocolUniqueness(operationMapping.endpoints)
    }

    /**
     * Check that communication types and endpoint protocols  of technology-specific protocol
     * specifications of a referred operation mapping are unique
     */
    @Check
    def checkProtocolSpecificationCommunicationTypesUniqueness(
        ReferredOperationMapping operationMapping) {
        checkCommunicationTypeUniqueness(operationMapping.protocols)
        checkEndpointProtocolUniqueness(operationMapping.endpoints)
    }

    /**
     * Helper to check that protocol/format combinations in endpoint mappings are unique
     */
    private def checkEndpointProtocolUniqueness(List<TechnologySpecificEndpoint> endpoints) {
        val protocolSet = <String> newHashSet
        endpoints.forEach[endpoint |
            for (i : 0..<endpoint.technologySpecificProtocols.size) {
                val technologySpecificProtocol = endpoint.technologySpecificProtocols.get(i)
                var protocolId = technologySpecificProtocol.protocol.name
                if (protocolId !== null && technologySpecificProtocol.dataFormat !== null)
                    protocolId += "/" + technologySpecificProtocol.dataFormat.formatName
                val boolean isDuplicate = if (protocolId !== null)
                    !protocolSet.add(protocolId)
                else
                    false

                if (isDuplicate)
                    error('''Duplicate protocol specification for endpoint «protocolId»''',
                        endpoint, MappingPackage::Literals
                            .TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS, i)
            }
        ]
    }

    /**
     * Check uniqueness of an endpoint's addresses
     */
    @Check
    def checkUniqueEndpointAddresses(TechnologySpecificEndpoint endpoint) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(endpoint.addresses, [it])
        if (duplicateIndex > -1) {
            val duplicate = endpoint.addresses.get(duplicateIndex)
            error('''Duplicate address «duplicate»''', endpoint,
                MappingPackage::Literals.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES, duplicateIndex)
        }
    }

    /**
     * Check that mapped microservice, interface, and operation technology-specific endpoints'
     * addresses are unique per protocol/data format combination
     */
    @Check
    def checkUniqueEndpointAddresses(TechnologyMapping model) {
        /* Check for microservices */
        val microserviceEndpoints = model.mappings.map[endpoints].flatten.toList
        checkUniqueEndpointAddresses(microserviceEndpoints, "microservice", [
            val importedMicroservice = microserviceMapping.microservice
            importedMicroservice.microservice.qualifiedNameParts
        ])

        /* Check for interfaces */
        val interfaceEndpoints = model.mappedInterfaces.map[endpoints].flatten.toList
        checkUniqueEndpointAddresses(interfaceEndpoints, "interface",
            [interfaceMapping.interface.qualifiedNameParts])

        /* Combined check for operations and referred operations */
        val List<TechnologySpecificEndpoint> operationEndpoints = newArrayList
        operationEndpoints.addAll(model.mappedReferredOperations.map[endpoints].flatten)
        operationEndpoints.addAll(model.mappedOperations.map[endpoints].flatten)
        checkUniqueEndpointAddresses(operationEndpoints, "operation", [
            if (operationMapping !== null)
                operationMapping.operation.qualifiedNameParts
            else if (referredOperationMapping !== null)
                referredOperationMapping.operation.qualifiedNameParts
        ])
    }

    /**
     * Check and warn if types of a primitive parameter mapping are not compatible. Note that we
     * just place a warning in case of (suspected) type incompatibility, as we also do it in the
     * service DSL.
     */
    @Check
    def warnPrimitiveParameterMappingTypeCompatibility(PrimitiveParameterMapping mapping) {
        warnParameterMappingTypeCompatibility(mapping)
    }

    /**
     * Check and warn if types of a complex parameter mapping are not compatible. Note that we just
     * place a warning in case of (suspected) type incompatibility, as we also do it in the service
     * DSL.
     */
    @Check
    def warnComplexParameterMappingTypeCompatibility(ComplexParameterMapping mapping) {
        warnParameterMappingTypeCompatibility(mapping)
    }

    /**
     * Check and warn if types of a data field mapping are not compatible. Note that we just place a
     * warning in case of (suspected) type incompatibility, as we also do it in the service DSL.
     */
    @Check
    def warnComplexParameterMappingTypeCompatibility(
        TechnologySpecificDataFieldTypeMapping mapping) {
        warnParameterMappingTypeCompatibility(mapping)
    }

    /**
     * Check that microservice mapping is not empty
     */
    @Check
    def checkNotEmpty(MicroserviceMapping mapping) {
        val isEmpty = mapping.protocols.empty &&
            mapping.endpoints.empty &&
            mapping.interfaceMappings.empty &&
            mapping.operationMappings.empty &&
            mapping.referredOperationMappings.empty &&
            mapping.aspects.empty

        if (isEmpty)
            error("Mapping must not be empty", mapping,
                MappingPackage::Literals.MICROSERVICE_MAPPING__MICROSERVICE)
    }

    /**
     * Check that interface mapping is not empty
     */
    @Check
    def checkNotEmpty(InterfaceMapping mapping) {
        val isEmpty = mapping.protocols.empty &&
            mapping.endpoints.empty &&
            mapping.aspects.empty

        if (isEmpty)
            error("Mapping must not be empty", mapping,
                MappingPackage::Literals.INTERFACE_MAPPING__INTERFACE)
    }

    /**
     * Check that operation mapping is not empty
     */
    @Check
    def checkNotEmpty(OperationMapping mapping) {
        val isEmpty = mapping.protocols.empty &&
            mapping.endpoints.empty &&
            mapping.parameterMappings.empty &&
            mapping.aspects.empty

        if (isEmpty)
            error("Mapping must not be empty", mapping,
                MappingPackage::Literals.OPERATION_MAPPING__OPERATION)
    }

    /**
     * Check that referred operation mapping is not empty
     */
    @Check
    def checkNotEmpty(ReferredOperationMapping mapping) {
        val isEmpty = mapping.protocols.empty &&
            mapping.endpoints.empty &&
            mapping.aspects.empty

        if (isEmpty)
            error("Mapping must not be empty", mapping,
                MappingPackage::Literals.REFERRED_OPERATION_MAPPING__OPERATION)
    }

    /**
     * Check that a parameter is mapped only once in an operation mapping
     */
    @Check
    def checkComplexParameterMappingUniqueParameters(OperationMapping mapping) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(mapping.parameterMappings, [parameter])
        if (duplicateIndex > -1) {
            val duplicateMapping = mapping.parameterMappings.get(duplicateIndex)
            val duplicateParameter = mapping.parameterMappings.get(duplicateIndex).parameter
            error('''Duplicate mapping for parameter «duplicateParameter.name»''',
                duplicateMapping, MappingPackage::Literals.PARAMETER_MAPPING__PARAMETER)
        }
    }

    /**
     * Check that a data field is mapped only once in a complex parameter mapping
     */
    @Check
    def checkComplexParameterMappingUniqueFields(ComplexParameterMapping mapping) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(mapping.dataFieldMappings,
            [it.dataFieldHierarchy.dataFields.last])
        if (duplicateIndex > -1) {
            val duplicateMapping = mapping.dataFieldMappings.get(duplicateIndex)
            val duplicateField = duplicateMapping.dataFieldHierarchy.dataFields.last
            error('''Duplicate mapping for data field «duplicateField.name»''', duplicateMapping,
                MappingPackage::Literals
                    .TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__DATA_FIELD_HIERARCHY)
        }
    }

    /**
     * Helper to check that communication types are unique
     */
    private def checkCommunicationTypeUniqueness(
        List<TechnologySpecificProtocolSpecification> protocolSpecifications) {
        for (int i : 0..<2) {
            val CommunicationType currentCommunicationType = switch (i) {
                case 0: CommunicationType.SYNCHRONOUS
                case 1: CommunicationType.ASYNCHRONOUS
            }

            val String currentCommunicationTypeName = switch (currentCommunicationType) {
                case SYNCHRONOUS: "synchronous"
                case ASYNCHRONOUS: "asynchronous"
            }

            val duplicateIndex = DdmmUtils.getDuplicateIndex(protocolSpecifications,
                [communicationType], [currentCommunicationType == it.communicationType])
            if (duplicateIndex === -1) {
                return
            }

            val duplicate = protocolSpecifications.get(duplicateIndex)
            error('''There must not be more than one «currentCommunicationTypeName» protocol ''' +
                '''being mapped''', duplicate, MappingPackage::Literals
                    .TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__COMMUNICATION_TYPE)
        }
    }

    /**
     * Helper to check that service-specific mappings are unique
     */
    private def <T extends EObject> checkMappingUniqueness(List<T> mappingsToCheck,
        String mappingName, Function<T, String> getMappingObjectName, EReference mappingFeature) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(mappingsToCheck, getMappingObjectName)

        if (duplicateIndex === -1) {
            return
        }

        val duplicate = mappingsToCheck.get(duplicateIndex)
        error('''«mappingName» is already mapped''', duplicate, mappingFeature)
    }

    /**
     * Convenience method to check uniqueness of endpoint addresses within a list of endpoints
     */
    private def checkUniqueEndpointAddresses(List<TechnologySpecificEndpoint> endpoints,
        String containerTypeName,
        Function<TechnologySpecificEndpoint, List<String>> getEndpointContainerNameParts) {
        /*
         * This ensures the uniqueness check. Its key is an address prefixed by its protocol and
         * data format if modeled. Assigned to each key is a multi-value (in the form of a map),
         * which stores the "pure" protocol/data format name and the Endpoint instance of the
         * address.
         */
        val uniqueAddressMap = <String, Map<String, Object>> newHashMap

        /* Iterate over endpoints, build map and perform uniqueness checks */
        endpoints.forEach[endpoint |
            for (i : 0..<endpoint.addresses.size) {
                endpoint.technologySpecificProtocols.forEach[technologySpecificProtocol |
                    val address = endpoint.addresses.get(i)
                    val protocol = technologySpecificProtocol.protocol
                    var protocolName = protocol.name
                    val dataFormat = technologySpecificProtocol.dataFormat
                    if (dataFormat !== null && dataFormat.formatName !== null)
                        protocolName += "/" + dataFormat.formatName
                    val addressPrefixedByProtocol = protocolName + address

                    val valueMap = <String, Object> newHashMap
                    valueMap.put("protocol", protocolName)
                    valueMap.put("endpoint", endpoint)
                    val duplicate = uniqueAddressMap.putIfAbsent(addressPrefixedByProtocol, valueMap)
                    val duplicateEndpoint = if (duplicate !== null)
                        duplicate.get("endpoint") as TechnologySpecificEndpoint

                    // If a duplicate was found we first check that it's not the same endpoint as
                    // being currently iterated. That is, to prevent adding an additional error,
                    // when an endpoint has a duplicate address. This check is performed separately
                    // per endpoint.
                    if (duplicateEndpoint !== null && duplicateEndpoint !== endpoint) {
                        val duplicateProtocolName = duplicate.get("protocol") as String
                        val duplicateContainerNameParts = getEndpointContainerNameParts
                            .apply(duplicateEndpoint)
                        val currentEndpointContainerNameParts = getEndpointContainerNameParts
                            .apply(endpoint)
                        val relativeDuplicateName = QualifiedName.create(
                            DdmmUtils.calculateRelativeQualifiedNameParts(
                                duplicateEndpoint, duplicateContainerNameParts, TechnologyMapping,
                                endpoint, currentEndpointContainerNameParts, TechnologyMapping
                            )
                        ).toString

                        error('''Address is already specified for protocol ''' +
                            '''«duplicateProtocolName» on ''' +
                            '''«containerTypeName» «relativeDuplicateName»''', endpoint,
                            MappingPackage::Literals.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES, i)
                    }
                ]
            }
        ]
    }

    /**
     * Convenience method for warning if types of a parameter mapping are not compatible with each
     * other
     */
    def warnParameterMappingTypeCompatibility(EObject mapping) {
        /*
         * Determine mapped type, its name, the original type, and the feature to place the warning
         * on
         */
        var Type mappedType
        var String mappedTypeName
        var Type originalType
        var EStructuralFeature erroneousMappingFeature
        switch (mapping) {
            // Primitive parameter mapping
            PrimitiveParameterMapping: {
                mappedType = mapping.primitiveType
                mappedTypeName = mapping.primitiveType.name
                originalType = mapping.parameter.primitiveType
                erroneousMappingFeature = MappingPackage::Literals.PARAMETER_MAPPING__PARAMETER
            }

            // Complex parameter mapping
            ComplexParameterMapping: {
                mappedType = mapping.technologySpecificComplexType
                mappedTypeName = mapping.technologySpecificComplexType.name
                originalType = mapping.parameter.importedType.type
                erroneousMappingFeature = MappingPackage::Literals.PARAMETER_MAPPING__PARAMETER
            }

            // Data field mapping
            TechnologySpecificDataFieldTypeMapping: {
                mappedType = mapping.type
                mappedTypeName = if (mappedType instanceof TechnologySpecificPrimitiveType)
                        mappedType.name
                    // The mapped type is, by all means, technology-specific even if here the data
                    // model-based superclass ComplexType is used (from which the technology-based
                    // variants of list and structure types inherit)
                    else if (mappedType instanceof ComplexType)
                        mappedType.name
                originalType = mapping.dataFieldHierarchy.dataFields.last.effectiveType
                erroneousMappingFeature = MappingPackage::Literals
                    .TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__DATA_FIELD_HIERARCHY
            }
        }

        // Might happen if there are syntax errors in the model because a non-existing parameter or
        // type was specified
        if (originalType === null || mappedType === null) {
            return
        }

        /* Perform the actual type check */
        try {
            new TypeChecker().checkTypeCompatibility(originalType, mappedType)
        } catch (TypesNotCompatibleException ex) {
            val originalTypeName = buildMappedTypeQualifiedName(mapping, originalType)
            warning('''Original type «originalTypeName» of parameter is not directly ''' +
                '''compatible with mapped type «mappedTypeName» ''', mapping,
                erroneousMappingFeature)
        }
    }

    /**
     * Check uniqueness of aspects
     */
    @Check
    def checkAspectsUniqueness(TechnologySpecificImportedServiceAspect importedAspect) {
        if (importedAspect.technology === null || importedAspect.technology.name === null ||
            importedAspect.aspect === null || importedAspect.aspect.name === null) {
            return
        }

        val allAspectsOfContainer = EcoreUtil2.getSiblingsOfType(importedAspect.eContainer,
            TechnologySpecificImportedServiceAspect)
        val duplicateIndex = DdmmUtils.getDuplicateIndex(allAspectsOfContainer,
            [QualifiedName.create(importedAspect.technology.name, aspect.name).toString],
            [aspect.name !== null])
        if (duplicateIndex > -1) {
            val duplicateAspect = allAspectsOfContainer.get(duplicateIndex)
            error("Aspect was already specified", duplicateAspect, MappingPackage
                .Literals::TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT)
        }
    }

    /**
     * Check that aspect has only one property, if only a single value is specified, and that the
     * specified value matches the property's type
     */
    @Check
    def checkSingleAspectProperty(TechnologySpecificImportedServiceAspect importedAspect) {
        val propertyValue = importedAspect.singlePropertyValue
        if (propertyValue === null) {
            return
        }

        val propertyCount = importedAspect.aspect.properties.size
        if (propertyCount > 1)
            error("Ambiguous value assignment", importedAspect, MappingPackage
                    .Literals::TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE)
        else if (propertyCount === 1) {
            val targetProperty = importedAspect.aspect.properties.get(0)
            val targetPropertyType = targetProperty.type
            if (!propertyValue.isOfType(targetPropertyType))
                error('''Value is not of type «targetPropertyType.typeName» as expected by ''' +
                '''property «targetProperty.name»''', importedAspect, MappingPackage
                    .Literals::TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE)
        }
    }

    /**
     * Check that mandatory properties of aspects have values
     */
    @Check
    def checkMandatoryAspectProperties(TechnologySpecificImportedServiceAspect importedAspect) {
        val aspect = importedAspect.aspect
        val aspectProperties = aspect.properties
        val mandatoryProperties = aspectProperties.filter[mandatory]
        val mandatoryPropertiesWithoutValues = mandatoryProperties.filter[
            !importedAspect.values.map[property].contains(it)
        ]
        val allMandatoryPropertiesHaveValues = mandatoryPropertiesWithoutValues.empty

        val aspectHasExactlyOneMandatoryProperty = aspectProperties.size === 1 &&
            !mandatoryProperties.empty
        if (aspectHasExactlyOneMandatoryProperty) {
            if (importedAspect.singlePropertyValue === null && !allMandatoryPropertiesHaveValues) {
                val mandatoryProperty = mandatoryProperties.get(0)
                error('''Mandatory property «mandatoryProperty.name» does not have value''',
                    importedAspect, MappingPackage
                        .Literals::TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT)
            }
        } else if (!allMandatoryPropertiesHaveValues) {
            mandatoryPropertiesWithoutValues.forEach[
               error('''Mandatory property «name» does not have value''', importedAspect,
                    MappingPackage.Literals::TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT)
            ]
        }
    }

    /**
     * Convenience method to build a qualified name for a type being used in a parameter mapping
     */
    private def buildMappedTypeQualifiedName(EObject mapping, Type type) {
        var String importAlias
        var List<String> nameParts

        /* Get alias (if type is imported) and name parts of fully-qualified type name */
        switch (mapping) {
            /* Primitive parameter mapping */
            PrimitiveParameterMapping:
                switch (type) {
                    // Primitive type is imported from a technology model
                    TechnologySpecificPrimitiveType: {
                        importAlias = mapping.parameter.importedType.import.name
                        nameParts = type.qualifiedNameParts
                    }

                    // Built-in primitive type
                    PrimitiveType: nameParts = #[type.typeName]
                }

            /* Complex parameter mapping */
            ComplexParameterMapping:
                switch (type) {
                    ComplexType: {
                        importAlias = mapping.parameter.importedType.import.name
                        nameParts = type.qualifiedNameParts
                    }
                }

            /*
             * Data field mapping. A data field either has a built-in primitive type or a complex
             * type from a data model. It may not have a technology-specific type of any kind
             * assigned.
             */
            TechnologySpecificDataFieldTypeMapping:
                switch (type) {
                    // Built-in primitive type
                    PrimitiveType: nameParts = #[type.typeName]

                    // Complex type being imported from data model
                    ComplexType: {
                        importAlias = mapping.parameterMapping.parameter.importedType.import.name
                        nameParts = type.qualifiedNameParts
                    }
            }
        }

        var qualifiedName = QualifiedName.create(nameParts).toString
        if (importAlias !== null)
            qualifiedName = importAlias + "::" + qualifiedName
        return qualifiedName
    }
}
