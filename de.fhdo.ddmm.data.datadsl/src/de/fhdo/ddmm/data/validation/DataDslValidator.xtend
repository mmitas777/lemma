/*
 * generated by Xtext 2.12.0
 */
package de.fhdo.ddmm.data.validation

import org.eclipse.xtext.validation.Check
import de.fhdo.ddmm.data.ComplexTypeImport
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.data.DataModel
import de.fhdo.ddmm.data.DataPackage
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.data.DataStructure
import de.fhdo.ddmm.data.DataField
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.data.Version
import com.google.common.base.Function
import java.util.List
import org.eclipse.emf.ecore.resource.Resource

/**
 * This class contains validation rules for the Data DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class DataDslValidator extends AbstractDataDslValidator {
    /* For debugging purposes to test the type checker. May be safely removed in the future. */
    /*@Check
    def checkAssignTest(AssignTest assignTest) {
        try {
            new TypeChecker().checkTypeCompatibility(assignTest.target.complexType,
                assignTest.source.complexType)
        } catch (TypesNotCompatibleException ex) {
            warning(ex.message, assignTest, DataPackage::Literals.ASSIGN_TEST__SOURCE)
        }
    }*/

    /**
     * Check import aliases for uniqueness. Normally, this should be done by
     * DataDslNamesAreUniqueValidationHelper, but it does not react to
     */
    @Check
    def checkImportAlias(DataModel dataModel) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(dataModel.complexTypeImports, [name])
        if (duplicateIndex === -1) {
            return
        }

        val duplicate = dataModel.complexTypeImports.get(duplicateIndex)
        error('''Duplicate import alias «duplicate.name»''', duplicate,
            DataPackage::Literals.COMPLEX_TYPE_IMPORT__NAME)
    }

    /**
     * Perform checks on data fields
     */
    @Check
    def checkDataField(DataField dataField) {
        /* A data field must either have a type or be hidden */
        if (dataField.effectiveType === null && !dataField.hidden) {
            error('''Field must have a type or be hidden''', dataField,
                    DataPackage::Literals.DATA_FIELD__NAME)

            return
        }

        val equalSuperField = dataField.findEponymousSuperField()
        /*
         * If there is no equally named super field or the super field is hidden (which means
         * that the complex type does not allow external callers to access it), the field must
         * have a type
         */
        if (equalSuperField === null || equalSuperField.hidden) {
            if (dataField.effectiveType === null)
                error('''Field must have a type''', dataField,
                    DataPackage::Literals.DATA_FIELD__NAME)

        /*
         * A field with a non-hidden super field (that therefore has a type) may not redefine the
         * super field by having a type
         */
        } else if (equalSuperField !== null && !equalSuperField.hidden) {
            var String superQualifiedName = QualifiedName
                .create(equalSuperField.qualifiedNameParts)
                .toString

            if (dataField.effectiveType !== null)
                error('''Field cannot redefine inherited field «superQualifiedName» ''', dataField,
                    DataPackage::Literals.DATA_FIELD__NAME)
        }
    }

    /**
     * Check if an imported file exists
     */
    @Check
    def checkImportFileExists(ComplexTypeImport complexTypeImport) {
        if (!DdmmUtils.importFileExists(complexTypeImport.eResource, complexTypeImport.importURI))
            error("File not found", complexTypeImport,
                DataPackage::Literals.COMPLEX_TYPE_IMPORT__IMPORT_URI)
    }

    /**
     * Check for cyclic inheritance relationships between data structures
     */
    @Check
    def checkCyclicInheritance(DataStructure dataStructure) {
        if (DdmmUtils.hasCyclicInheritance(dataStructure, [it.super]))
            error("Cyclic inheritance detected", dataStructure,
                DataPackage::Literals.COMPLEX_TYPE__NAME)
    }

    /**
     * Check for cyclic imports (non-transitive)
     */
    @Check
    def checkForCyclicImports(ComplexTypeImport complexTypeImport) {
        // Function to retrieve all imported Ecore resources of a data model
        val Function<DataModel, List<Resource>> getImportedDataModelResources =
            [complexTypeImports.map[
                EcoreUtil2.getResource(eResource, importURI)
            ]]

        if (DdmmUtils.isCyclicImport(complexTypeImport, DataModel, getImportedDataModelResources))
            error("Cyclic import detected", complexTypeImport,
                DataPackage::Literals.COMPLEX_TYPE_IMPORT__IMPORT_URI)
    }

    /**
     * Check versions for non-emptyness
     */
    @Check
    def checkVersionNotEmpty(Version version) {
        if (version.contexts.empty && version.complexTypes.empty)
            error("A version must define at least one context or complex type", version,
                DataPackage::Literals.VERSION__NAME)
    }
}
