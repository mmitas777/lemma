/**
 */
package de.fhdo.ddmm.technology.mapping;

import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.TechnologyReference;

import de.fhdo.ddmm.technology.Technology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Mapping for complex types
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getTechnologyReferences <em>Technology References</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getFieldMappings <em>Field Mappings</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getMappingModel <em>Mapping Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexTypeMapping()
 * @model
 * @generated
 */
public interface ComplexTypeMapping extends EObject {
    /**
     * Returns the value of the '<em><b>Tsource Model Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tsource Model Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tsource Model Uri</em>' attribute.
     * @see #setT_sourceModelUri(String)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexTypeMapping_T_sourceModelUri()
     * @model unique="false"
     * @generated
     */
    String getT_sourceModelUri();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getT_sourceModelUri <em>Tsource Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tsource Model Uri</em>' attribute.
     * @see #getT_sourceModelUri()
     * @generated
     */
    void setT_sourceModelUri(String value);

    /**
     * Returns the value of the '<em><b>Technology References</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.TechnologyReference}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology References</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology References</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexTypeMapping_TechnologyReferences()
     * @model containment="true"
     * @generated
     */
    EList<TechnologyReference> getTechnologyReferences();

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.ImportedComplexType#getTypeMapping <em>Type Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(ImportedComplexType)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexTypeMapping_Type()
     * @see de.fhdo.ddmm.technology.mapping.ImportedComplexType#getTypeMapping
     * @model opposite="typeMapping" containment="true"
     * @generated
     */
    ImportedComplexType getType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(ImportedComplexType value);

    /**
     * Returns the value of the '<em><b>Field Mappings</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getTypeMapping <em>Type Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field Mappings</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexTypeMapping_FieldMappings()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping#getTypeMapping
     * @model opposite="typeMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificFieldMapping> getFieldMappings();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getTypeMapping <em>Type Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexTypeMapping_Aspects()
     * @see de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect#getTypeMapping
     * @model opposite="typeMapping" containment="true"
     * @generated
     */
    EList<TechnologySpecificImportedServiceAspect> getAspects();

    /**
     * Returns the value of the '<em><b>Mapping Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.technology.mapping.TechnologyMapping#getTypeMappings <em>Type Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapping Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping Model</em>' container reference.
     * @see #setMappingModel(TechnologyMapping)
     * @see de.fhdo.ddmm.technology.mapping.MappingPackage#getComplexTypeMapping_MappingModel()
     * @see de.fhdo.ddmm.technology.mapping.TechnologyMapping#getTypeMappings
     * @model opposite="typeMappings" transient="false"
     * @generated
     */
    TechnologyMapping getMappingModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.technology.mapping.ComplexTypeMapping#getMappingModel <em>Mapping Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapping Model</em>' container reference.
     * @see #getMappingModel()
     * @generated
     */
    void setMappingModel(TechnologyMapping value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get all technology references that point to technology models defining types
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    EList<TechnologyReference> getAllTypeDefinitionTechnologyReferences();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get import of type definition technology. If no explicit technology reference was marked as
     * pointing to the default type definition technology, this corresponds to the first technology
     * import in the list of type definition technology imports. This operation should only be
     * executed if the model had been validated to refer to one type definition technology at most.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    Import getTypeDefinitionTechnologyImport();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Get type definition technology
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false"
     * @generated
     */
    Technology getTypeDefinitionTechnology();

} // ComplexTypeMapping
