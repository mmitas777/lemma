/*
 * generated by Xtext 2.25.0
 */
package de.fhdo.lemma.technology.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.fhdo.lemma.technology.ide.contentassist.antlr.internal.InternalTechnologyDslParser;
import de.fhdo.lemma.technology.services.TechnologyDslGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class TechnologyDslParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(TechnologyDslGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, TechnologyDslGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getTechnologyAccess().getAlternatives_4_2(), "rule__Technology__Alternatives_4_2");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getAlternatives(), "rule__ServiceAspectPointcut__Alternatives");
			builder.put(grammarAccess.getServiceAspectAccess().getAlternatives_6(), "rule__ServiceAspect__Alternatives_6");
			builder.put(grammarAccess.getOperationAspectAccess().getAlternatives_6(), "rule__OperationAspect__Alternatives_6");
			builder.put(grammarAccess.getDataModelAccess().getAlternatives_1(), "rule__DataModel__Alternatives_1");
			builder.put(grammarAccess.getVersionAccess().getAlternatives_3(), "rule__Version__Alternatives_3");
			builder.put(grammarAccess.getComplexTypeAccess().getAlternatives(), "rule__ComplexType__Alternatives");
			builder.put(grammarAccess.getDataStructureAccess().getAlternatives_5_0(), "rule__DataStructure__Alternatives_5_0");
			builder.put(grammarAccess.getDataStructureAccess().getAlternatives_5_1_1(), "rule__DataStructure__Alternatives_5_1_1");
			builder.put(grammarAccess.getListTypeAccess().getAlternatives(), "rule__ListType__Alternatives");
			builder.put(grammarAccess.getListTypeAccess().getAlternatives_0_0(), "rule__ListType__Alternatives_0_0");
			builder.put(grammarAccess.getListTypeAccess().getAlternatives_1_0(), "rule__ListType__Alternatives_1_0");
			builder.put(grammarAccess.getDataFieldAccess().getAlternatives_2(), "rule__DataField__Alternatives_2");
			builder.put(grammarAccess.getDataOperationAccess().getAlternatives_1(), "rule__DataOperation__Alternatives_1");
			builder.put(grammarAccess.getDataOperationAccess().getAlternatives_1_1_1(), "rule__DataOperation__Alternatives_1_1_1");
			builder.put(grammarAccess.getDataOperationParameterAccess().getAlternatives_0(), "rule__DataOperationParameter__Alternatives_0");
			builder.put(grammarAccess.getPrimitiveValueAccess().getAlternatives(), "rule__PrimitiveValue__Alternatives");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getAlternatives(), "rule__PrimitiveType__Alternatives");
			builder.put(grammarAccess.getExchangePatternAccess().getAlternatives(), "rule__ExchangePattern__Alternatives");
			builder.put(grammarAccess.getCommunicationTypeAccess().getAlternatives(), "rule__CommunicationType__Alternatives");
			builder.put(grammarAccess.getCompatibilityDirectionAccess().getAlternatives(), "rule__CompatibilityDirection__Alternatives");
			builder.put(grammarAccess.getPropertyFeatureAccess().getAlternatives(), "rule__PropertyFeature__Alternatives");
			builder.put(grammarAccess.getServiceJoinPointTypeAccess().getAlternatives(), "rule__ServiceJoinPointType__Alternatives");
			builder.put(grammarAccess.getOperationJoinPointTypeAccess().getAlternatives(), "rule__OperationJoinPointType__Alternatives");
			builder.put(grammarAccess.getComplexTypeFeatureAccess().getAlternatives(), "rule__ComplexTypeFeature__Alternatives");
			builder.put(grammarAccess.getDataFieldFeatureAccess().getAlternatives(), "rule__DataFieldFeature__Alternatives");
			builder.put(grammarAccess.getDataOperationFeatureAccess().getAlternatives(), "rule__DataOperationFeature__Alternatives");
			builder.put(grammarAccess.getTechnologyAccess().getGroup(), "rule__Technology__Group__0");
			builder.put(grammarAccess.getTechnologyAccess().getGroup_4(), "rule__Technology__Group_4__0");
			builder.put(grammarAccess.getTechnologyAccess().getGroup_4_3(), "rule__Technology__Group_4_3__0");
			builder.put(grammarAccess.getTechnologyAccess().getGroup_5(), "rule__Technology__Group_5__0");
			builder.put(grammarAccess.getTechnologyAccess().getGroup_6(), "rule__Technology__Group_6__0");
			builder.put(grammarAccess.getTechnologyAccess().getGroup_7(), "rule__Technology__Group_7__0");
			builder.put(grammarAccess.getTechnologyAccess().getGroup_8(), "rule__Technology__Group_8__0");
			builder.put(grammarAccess.getTechnologyAccess().getGroup_9(), "rule__Technology__Group_9__0");
			builder.put(grammarAccess.getTechnologyImportAccess().getGroup(), "rule__TechnologyImport__Group__0");
			builder.put(grammarAccess.getProtocolAccess().getGroup(), "rule__Protocol__Group__0");
			builder.put(grammarAccess.getProtocolAccess().getGroup_5(), "rule__Protocol__Group_5__0");
			builder.put(grammarAccess.getProtocolAccess().getGroup_6(), "rule__Protocol__Group_6__0");
			builder.put(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup(), "rule__TechnologySpecificPrimitiveType__Group__0");
			builder.put(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3(), "rule__TechnologySpecificPrimitiveType__Group_3__0");
			builder.put(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3_3(), "rule__TechnologySpecificPrimitiveType__Group_3_3__0");
			builder.put(grammarAccess.getTechnologySpecificListTypeAccess().getGroup(), "rule__TechnologySpecificListType__Group__0");
			builder.put(grammarAccess.getTechnologySpecificDataStructureAccess().getGroup(), "rule__TechnologySpecificDataStructure__Group__0");
			builder.put(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getGroup(), "rule__PossiblyImportedTechnologySpecificType__Group__0");
			builder.put(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getGroup_0(), "rule__PossiblyImportedTechnologySpecificType__Group_0__0");
			builder.put(grammarAccess.getCompatibilityMatrixEntryAccess().getGroup(), "rule__CompatibilityMatrixEntry__Group__0");
			builder.put(grammarAccess.getCompatibilityMatrixEntryAccess().getGroup_1(), "rule__CompatibilityMatrixEntry__Group_1__0");
			builder.put(grammarAccess.getDeploymentTechnologyAccess().getGroup(), "rule__DeploymentTechnology__Group__0");
			builder.put(grammarAccess.getDeploymentTechnologyAccess().getGroup_6(), "rule__DeploymentTechnology__Group_6__0");
			builder.put(grammarAccess.getDeploymentTechnologyAccess().getGroup_8(), "rule__DeploymentTechnology__Group_8__0");
			builder.put(grammarAccess.getInfrastructureTechnologyAccess().getGroup(), "rule__InfrastructureTechnology__Group__0");
			builder.put(grammarAccess.getInfrastructureTechnologyAccess().getGroup_6(), "rule__InfrastructureTechnology__Group_6__0");
			builder.put(grammarAccess.getInfrastructureTechnologyAccess().getGroup_8(), "rule__InfrastructureTechnology__Group_8__0");
			builder.put(grammarAccess.getOperationEnvironmentAccess().getGroup(), "rule__OperationEnvironment__Group__0");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getGroup(), "rule__TechnologySpecificProperty__Group__0");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getGroup_2(), "rule__TechnologySpecificProperty__Group_2__0");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getGroup_3(), "rule__TechnologySpecificProperty__Group_3__0");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getGroup_3_2(), "rule__TechnologySpecificProperty__Group_3_2__0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getGroup_0(), "rule__ServiceAspectPointcut__Group_0__0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getGroup_1(), "rule__ServiceAspectPointcut__Group_1__0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getGroup_2(), "rule__ServiceAspectPointcut__Group_2__0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getGroup_3(), "rule__ServiceAspectPointcut__Group_3__0");
			builder.put(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup(), "rule__ServiceAspectPointcutSelector__Group__0");
			builder.put(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup_3(), "rule__ServiceAspectPointcutSelector__Group_3__0");
			builder.put(grammarAccess.getServiceAspectAccess().getGroup(), "rule__ServiceAspect__Group__0");
			builder.put(grammarAccess.getServiceAspectAccess().getGroup_2(), "rule__ServiceAspect__Group_2__0");
			builder.put(grammarAccess.getServiceAspectAccess().getGroup_2_2(), "rule__ServiceAspect__Group_2_2__0");
			builder.put(grammarAccess.getServiceAspectAccess().getGroup_5(), "rule__ServiceAspect__Group_5__0");
			builder.put(grammarAccess.getServiceAspectAccess().getGroup_6_0(), "rule__ServiceAspect__Group_6_0__0");
			builder.put(grammarAccess.getOperationAspectPointcutAccess().getGroup(), "rule__OperationAspectPointcut__Group__0");
			builder.put(grammarAccess.getOperationAspectPointcutSelectorAccess().getGroup(), "rule__OperationAspectPointcutSelector__Group__0");
			builder.put(grammarAccess.getOperationAspectPointcutSelectorAccess().getGroup_3(), "rule__OperationAspectPointcutSelector__Group_3__0");
			builder.put(grammarAccess.getOperationAspectAccess().getGroup(), "rule__OperationAspect__Group__0");
			builder.put(grammarAccess.getOperationAspectAccess().getGroup_2(), "rule__OperationAspect__Group_2__0");
			builder.put(grammarAccess.getOperationAspectAccess().getGroup_2_2(), "rule__OperationAspect__Group_2_2__0");
			builder.put(grammarAccess.getOperationAspectAccess().getGroup_5(), "rule__OperationAspect__Group_5__0");
			builder.put(grammarAccess.getOperationAspectAccess().getGroup_6_0(), "rule__OperationAspect__Group_6_0__0");
			builder.put(grammarAccess.getDataModelAccess().getGroup(), "rule__DataModel__Group__0");
			builder.put(grammarAccess.getComplexTypeImportAccess().getGroup(), "rule__ComplexTypeImport__Group__0");
			builder.put(grammarAccess.getVersionAccess().getGroup(), "rule__Version__Group__0");
			builder.put(grammarAccess.getContextAccess().getGroup(), "rule__Context__Group__0");
			builder.put(grammarAccess.getDataStructureAccess().getGroup(), "rule__DataStructure__Group__0");
			builder.put(grammarAccess.getDataStructureAccess().getGroup_2(), "rule__DataStructure__Group_2__0");
			builder.put(grammarAccess.getDataStructureAccess().getGroup_2_2(), "rule__DataStructure__Group_2_2__0");
			builder.put(grammarAccess.getDataStructureAccess().getGroup_3(), "rule__DataStructure__Group_3__0");
			builder.put(grammarAccess.getDataStructureAccess().getGroup_5(), "rule__DataStructure__Group_5__0");
			builder.put(grammarAccess.getDataStructureAccess().getGroup_5_1(), "rule__DataStructure__Group_5_1__0");
			builder.put(grammarAccess.getListTypeAccess().getGroup_0(), "rule__ListType__Group_0__0");
			builder.put(grammarAccess.getListTypeAccess().getGroup_0_4(), "rule__ListType__Group_0_4__0");
			builder.put(grammarAccess.getListTypeAccess().getGroup_1(), "rule__ListType__Group_1__0");
			builder.put(grammarAccess.getDataFieldAccess().getGroup(), "rule__DataField__Group__0");
			builder.put(grammarAccess.getDataFieldAccess().getGroup_4(), "rule__DataField__Group_4__0");
			builder.put(grammarAccess.getDataFieldAccess().getGroup_5(), "rule__DataField__Group_5__0");
			builder.put(grammarAccess.getDataFieldAccess().getGroup_5_2(), "rule__DataField__Group_5_2__0");
			builder.put(grammarAccess.getEnumerationAccess().getGroup(), "rule__Enumeration__Group__0");
			builder.put(grammarAccess.getEnumerationAccess().getGroup_2(), "rule__Enumeration__Group_2__0");
			builder.put(grammarAccess.getEnumerationAccess().getGroup_2_2(), "rule__Enumeration__Group_2_2__0");
			builder.put(grammarAccess.getEnumerationAccess().getGroup_5(), "rule__Enumeration__Group_5__0");
			builder.put(grammarAccess.getEnumerationFieldAccess().getGroup(), "rule__EnumerationField__Group__0");
			builder.put(grammarAccess.getEnumerationFieldAccess().getGroup_1(), "rule__EnumerationField__Group_1__0");
			builder.put(grammarAccess.getDataOperationAccess().getGroup(), "rule__DataOperation__Group__0");
			builder.put(grammarAccess.getDataOperationAccess().getGroup_1_1(), "rule__DataOperation__Group_1_1__0");
			builder.put(grammarAccess.getDataOperationAccess().getGroup_3(), "rule__DataOperation__Group_3__0");
			builder.put(grammarAccess.getDataOperationAccess().getGroup_3_2(), "rule__DataOperation__Group_3_2__0");
			builder.put(grammarAccess.getDataOperationAccess().getGroup_4(), "rule__DataOperation__Group_4__0");
			builder.put(grammarAccess.getDataOperationAccess().getGroup_4_2(), "rule__DataOperation__Group_4_2__0");
			builder.put(grammarAccess.getDataOperationParameterAccess().getGroup(), "rule__DataOperationParameter__Group__0");
			builder.put(grammarAccess.getImportedComplexTypeAccess().getGroup(), "rule__ImportedComplexType__Group__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_0(), "rule__PrimitiveType__Group_0__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_1(), "rule__PrimitiveType__Group_1__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_2(), "rule__PrimitiveType__Group_2__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_3(), "rule__PrimitiveType__Group_3__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_4(), "rule__PrimitiveType__Group_4__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_5(), "rule__PrimitiveType__Group_5__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_6(), "rule__PrimitiveType__Group_6__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_7(), "rule__PrimitiveType__Group_7__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_8(), "rule__PrimitiveType__Group_8__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_9(), "rule__PrimitiveType__Group_9__0");
			builder.put(grammarAccess.getPrimitiveTypeAccess().getGroup_10(), "rule__PrimitiveType__Group_10__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getTechnologyAccess().getImportsAssignment_0(), "rule__Technology__ImportsAssignment_0");
			builder.put(grammarAccess.getTechnologyAccess().getNameAssignment_2(), "rule__Technology__NameAssignment_2");
			builder.put(grammarAccess.getTechnologyAccess().getPrimitiveTypesAssignment_4_2_0(), "rule__Technology__PrimitiveTypesAssignment_4_2_0");
			builder.put(grammarAccess.getTechnologyAccess().getListTypesAssignment_4_2_1(), "rule__Technology__ListTypesAssignment_4_2_1");
			builder.put(grammarAccess.getTechnologyAccess().getDataStructuresAssignment_4_2_2(), "rule__Technology__DataStructuresAssignment_4_2_2");
			builder.put(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3(), "rule__Technology__CompatibilityEntriesAssignment_4_3_3");
			builder.put(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2(), "rule__Technology__ProtocolsAssignment_5_2");
			builder.put(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3(), "rule__Technology__ServiceAspectsAssignment_6_3");
			builder.put(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3(), "rule__Technology__DeploymentTechnologiesAssignment_7_3");
			builder.put(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3(), "rule__Technology__InfrastructureTechnologiesAssignment_8_3");
			builder.put(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3(), "rule__Technology__OperationAspectsAssignment_9_3");
			builder.put(grammarAccess.getTechnologyImportAccess().getImportURIAssignment_3(), "rule__TechnologyImport__ImportURIAssignment_3");
			builder.put(grammarAccess.getTechnologyImportAccess().getNameAssignment_5(), "rule__TechnologyImport__NameAssignment_5");
			builder.put(grammarAccess.getProtocolAccess().getCommunicationTypeAssignment_0(), "rule__Protocol__CommunicationTypeAssignment_0");
			builder.put(grammarAccess.getProtocolAccess().getNameAssignment_1(), "rule__Protocol__NameAssignment_1");
			builder.put(grammarAccess.getProtocolAccess().getDataFormatsAssignment_4(), "rule__Protocol__DataFormatsAssignment_4");
			builder.put(grammarAccess.getProtocolAccess().getDataFormatsAssignment_5_1(), "rule__Protocol__DataFormatsAssignment_5_1");
			builder.put(grammarAccess.getProtocolAccess().getDefaultAssignment_6_0(), "rule__Protocol__DefaultAssignment_6_0");
			builder.put(grammarAccess.getProtocolAccess().getDefaultFormatAssignment_6_3(), "rule__Protocol__DefaultFormatAssignment_6_3");
			builder.put(grammarAccess.getDataFormatAccess().getFormatNameAssignment(), "rule__DataFormat__FormatNameAssignment");
			builder.put(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getNameAssignment_2(), "rule__TechnologySpecificPrimitiveType__NameAssignment_2");
			builder.put(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_2(), "rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2");
			builder.put(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_3_1(), "rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1");
			builder.put(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultAssignment_3_4(), "rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4");
			builder.put(grammarAccess.getTechnologySpecificListTypeAccess().getNameAssignment_2(), "rule__TechnologySpecificListType__NameAssignment_2");
			builder.put(grammarAccess.getTechnologySpecificDataStructureAccess().getNameAssignment_2(), "rule__TechnologySpecificDataStructure__NameAssignment_2");
			builder.put(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportAssignment_0_0(), "rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0");
			builder.put(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeAssignment_1(), "rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1");
			builder.put(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_0(), "rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0");
			builder.put(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_1_1(), "rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1");
			builder.put(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionAssignment_2(), "rule__CompatibilityMatrixEntry__DirectionAssignment_2");
			builder.put(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypeAssignment_3(), "rule__CompatibilityMatrixEntry__MappingTypeAssignment_3");
			builder.put(grammarAccess.getDeploymentTechnologyAccess().getNameAssignment_0(), "rule__DeploymentTechnology__NameAssignment_0");
			builder.put(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_5(), "rule__DeploymentTechnology__OperationEnvironmentsAssignment_5");
			builder.put(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_6_1(), "rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1");
			builder.put(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3(), "rule__DeploymentTechnology__ServicePropertiesAssignment_8_3");
			builder.put(grammarAccess.getInfrastructureTechnologyAccess().getNameAssignment_0(), "rule__InfrastructureTechnology__NameAssignment_0");
			builder.put(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_5(), "rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5");
			builder.put(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_6_1(), "rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1");
			builder.put(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3(), "rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3");
			builder.put(grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameAssignment_0(), "rule__OperationEnvironment__EnvironmentNameAssignment_0");
			builder.put(grammarAccess.getOperationEnvironmentAccess().getDefaultAssignment_1(), "rule__OperationEnvironment__DefaultAssignment_1");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getTypeAssignment_0(), "rule__TechnologySpecificProperty__TypeAssignment_0");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getNameAssignment_1(), "rule__TechnologySpecificProperty__NameAssignment_1");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValueAssignment_2_1(), "rule__TechnologySpecificProperty__DefaultValueAssignment_2_1");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesAssignment_3_1(), "rule__TechnologySpecificProperty__FeaturesAssignment_3_1");
			builder.put(grammarAccess.getTechnologySpecificPropertyAccess().getFeaturesAssignment_3_2_1(), "rule__TechnologySpecificProperty__FeaturesAssignment_3_2_1");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternAssignment_0_0(), "rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getExchangePatternAssignment_0_2(), "rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeAssignment_1_0(), "rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getCommunicationTypeAssignment_1_2(), "rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getForProtocolAssignment_2_0(), "rule__ServiceAspectPointcut__ForProtocolAssignment_2_0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getProtocolAssignment_2_2(), "rule__ServiceAspectPointcut__ProtocolAssignment_2_2");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatAssignment_3_0(), "rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0");
			builder.put(grammarAccess.getServiceAspectPointcutAccess().getDataFormatAssignment_3_2(), "rule__ServiceAspectPointcut__DataFormatAssignment_3_2");
			builder.put(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_2(), "rule__ServiceAspectPointcutSelector__PointcutsAssignment_2");
			builder.put(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_3_1(), "rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1");
			builder.put(grammarAccess.getServiceAspectAccess().getNameAssignment_1(), "rule__ServiceAspect__NameAssignment_1");
			builder.put(grammarAccess.getServiceAspectAccess().getFeaturesAssignment_2_1(), "rule__ServiceAspect__FeaturesAssignment_2_1");
			builder.put(grammarAccess.getServiceAspectAccess().getFeaturesAssignment_2_2_1(), "rule__ServiceAspect__FeaturesAssignment_2_2_1");
			builder.put(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_4(), "rule__ServiceAspect__JoinPointsAssignment_4");
			builder.put(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_5_1(), "rule__ServiceAspect__JoinPointsAssignment_5_1");
			builder.put(grammarAccess.getServiceAspectAccess().getPointcutSelectorsAssignment_6_0_1(), "rule__ServiceAspect__PointcutSelectorsAssignment_6_0_1");
			builder.put(grammarAccess.getServiceAspectAccess().getPropertiesAssignment_6_0_2(), "rule__ServiceAspect__PropertiesAssignment_6_0_2");
			builder.put(grammarAccess.getOperationAspectPointcutAccess().getForTechnologyAssignment_0(), "rule__OperationAspectPointcut__ForTechnologyAssignment_0");
			builder.put(grammarAccess.getOperationAspectPointcutAccess().getTechnologyAssignment_2(), "rule__OperationAspectPointcut__TechnologyAssignment_2");
			builder.put(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsAssignment_2(), "rule__OperationAspectPointcutSelector__PointcutsAssignment_2");
			builder.put(grammarAccess.getOperationAspectPointcutSelectorAccess().getPointcutsAssignment_3_1(), "rule__OperationAspectPointcutSelector__PointcutsAssignment_3_1");
			builder.put(grammarAccess.getOperationAspectAccess().getNameAssignment_1(), "rule__OperationAspect__NameAssignment_1");
			builder.put(grammarAccess.getOperationAspectAccess().getFeaturesAssignment_2_1(), "rule__OperationAspect__FeaturesAssignment_2_1");
			builder.put(grammarAccess.getOperationAspectAccess().getFeaturesAssignment_2_2_1(), "rule__OperationAspect__FeaturesAssignment_2_2_1");
			builder.put(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_4(), "rule__OperationAspect__JoinPointsAssignment_4");
			builder.put(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_5_1(), "rule__OperationAspect__JoinPointsAssignment_5_1");
			builder.put(grammarAccess.getOperationAspectAccess().getPointcutSelectorsAssignment_6_0_1(), "rule__OperationAspect__PointcutSelectorsAssignment_6_0_1");
			builder.put(grammarAccess.getOperationAspectAccess().getPropertiesAssignment_6_0_2(), "rule__OperationAspect__PropertiesAssignment_6_0_2");
			builder.put(grammarAccess.getDataModelAccess().getComplexTypeImportsAssignment_0(), "rule__DataModel__ComplexTypeImportsAssignment_0");
			builder.put(grammarAccess.getDataModelAccess().getVersionsAssignment_1_0(), "rule__DataModel__VersionsAssignment_1_0");
			builder.put(grammarAccess.getDataModelAccess().getContextsAssignment_1_1(), "rule__DataModel__ContextsAssignment_1_1");
			builder.put(grammarAccess.getDataModelAccess().getComplexTypesAssignment_1_2(), "rule__DataModel__ComplexTypesAssignment_1_2");
			builder.put(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3(), "rule__ComplexTypeImport__ImportURIAssignment_3");
			builder.put(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5(), "rule__ComplexTypeImport__NameAssignment_5");
			builder.put(grammarAccess.getVersionAccess().getNameAssignment_1(), "rule__Version__NameAssignment_1");
			builder.put(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0(), "rule__Version__ComplexTypesAssignment_3_0");
			builder.put(grammarAccess.getVersionAccess().getContextsAssignment_3_1(), "rule__Version__ContextsAssignment_3_1");
			builder.put(grammarAccess.getContextAccess().getNameAssignment_1(), "rule__Context__NameAssignment_1");
			builder.put(grammarAccess.getContextAccess().getComplexTypesAssignment_3(), "rule__Context__ComplexTypesAssignment_3");
			builder.put(grammarAccess.getDataStructureAccess().getNameAssignment_1(), "rule__DataStructure__NameAssignment_1");
			builder.put(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_1(), "rule__DataStructure__FeaturesAssignment_2_1");
			builder.put(grammarAccess.getDataStructureAccess().getFeaturesAssignment_2_2_1(), "rule__DataStructure__FeaturesAssignment_2_2_1");
			builder.put(grammarAccess.getDataStructureAccess().getSuperAssignment_3_1(), "rule__DataStructure__SuperAssignment_3_1");
			builder.put(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_5_0_0(), "rule__DataStructure__DataFieldsAssignment_5_0_0");
			builder.put(grammarAccess.getDataStructureAccess().getOperationsAssignment_5_0_1(), "rule__DataStructure__OperationsAssignment_5_0_1");
			builder.put(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_5_1_1_0(), "rule__DataStructure__DataFieldsAssignment_5_1_1_0");
			builder.put(grammarAccess.getDataStructureAccess().getOperationsAssignment_5_1_1_1(), "rule__DataStructure__OperationsAssignment_5_1_1_1");
			builder.put(grammarAccess.getListTypeAccess().getNameAssignment_0_1(), "rule__ListType__NameAssignment_0_1");
			builder.put(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3(), "rule__ListType__DataFieldsAssignment_0_3");
			builder.put(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1(), "rule__ListType__DataFieldsAssignment_0_4_1");
			builder.put(grammarAccess.getListTypeAccess().getNameAssignment_1_1(), "rule__ListType__NameAssignment_1_1");
			builder.put(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3(), "rule__ListType__PrimitiveTypeAssignment_1_3");
			builder.put(grammarAccess.getDataFieldAccess().getHiddenAssignment_0(), "rule__DataField__HiddenAssignment_0");
			builder.put(grammarAccess.getDataFieldAccess().getImmutableAssignment_1(), "rule__DataField__ImmutableAssignment_1");
			builder.put(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_2_0(), "rule__DataField__PrimitiveTypeAssignment_2_0");
			builder.put(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_2_1(), "rule__DataField__ComplexTypeAssignment_2_1");
			builder.put(grammarAccess.getDataFieldAccess().getImportedComplexTypeAssignment_2_2(), "rule__DataField__ImportedComplexTypeAssignment_2_2");
			builder.put(grammarAccess.getDataFieldAccess().getNameAssignment_3(), "rule__DataField__NameAssignment_3");
			builder.put(grammarAccess.getDataFieldAccess().getInitializationValueAssignment_4_1(), "rule__DataField__InitializationValueAssignment_4_1");
			builder.put(grammarAccess.getDataFieldAccess().getFeaturesAssignment_5_1(), "rule__DataField__FeaturesAssignment_5_1");
			builder.put(grammarAccess.getDataFieldAccess().getFeaturesAssignment_5_2_1(), "rule__DataField__FeaturesAssignment_5_2_1");
			builder.put(grammarAccess.getEnumerationAccess().getNameAssignment_1(), "rule__Enumeration__NameAssignment_1");
			builder.put(grammarAccess.getEnumerationAccess().getFeaturesAssignment_2_1(), "rule__Enumeration__FeaturesAssignment_2_1");
			builder.put(grammarAccess.getEnumerationAccess().getFeaturesAssignment_2_2_1(), "rule__Enumeration__FeaturesAssignment_2_2_1");
			builder.put(grammarAccess.getEnumerationAccess().getFieldsAssignment_4(), "rule__Enumeration__FieldsAssignment_4");
			builder.put(grammarAccess.getEnumerationAccess().getFieldsAssignment_5_1(), "rule__Enumeration__FieldsAssignment_5_1");
			builder.put(grammarAccess.getEnumerationFieldAccess().getNameAssignment_0(), "rule__EnumerationField__NameAssignment_0");
			builder.put(grammarAccess.getEnumerationFieldAccess().getInitializationValueAssignment_1_1(), "rule__EnumerationField__InitializationValueAssignment_1_1");
			builder.put(grammarAccess.getDataOperationAccess().getHiddenAssignment_0(), "rule__DataOperation__HiddenAssignment_0");
			builder.put(grammarAccess.getDataOperationAccess().getHasNoReturnTypeAssignment_1_0(), "rule__DataOperation__HasNoReturnTypeAssignment_1_0");
			builder.put(grammarAccess.getDataOperationAccess().getPrimitiveReturnTypeAssignment_1_1_1_0(), "rule__DataOperation__PrimitiveReturnTypeAssignment_1_1_1_0");
			builder.put(grammarAccess.getDataOperationAccess().getComplexReturnTypeAssignment_1_1_1_1(), "rule__DataOperation__ComplexReturnTypeAssignment_1_1_1_1");
			builder.put(grammarAccess.getDataOperationAccess().getImportedComplexReturnTypeAssignment_1_1_1_2(), "rule__DataOperation__ImportedComplexReturnTypeAssignment_1_1_1_2");
			builder.put(grammarAccess.getDataOperationAccess().getNameAssignment_2(), "rule__DataOperation__NameAssignment_2");
			builder.put(grammarAccess.getDataOperationAccess().getParametersAssignment_3_1(), "rule__DataOperation__ParametersAssignment_3_1");
			builder.put(grammarAccess.getDataOperationAccess().getParametersAssignment_3_2_1(), "rule__DataOperation__ParametersAssignment_3_2_1");
			builder.put(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_1(), "rule__DataOperation__FeaturesAssignment_4_1");
			builder.put(grammarAccess.getDataOperationAccess().getFeaturesAssignment_4_2_1(), "rule__DataOperation__FeaturesAssignment_4_2_1");
			builder.put(grammarAccess.getDataOperationParameterAccess().getPrimitiveTypeAssignment_0_0(), "rule__DataOperationParameter__PrimitiveTypeAssignment_0_0");
			builder.put(grammarAccess.getDataOperationParameterAccess().getComplexTypeAssignment_0_1(), "rule__DataOperationParameter__ComplexTypeAssignment_0_1");
			builder.put(grammarAccess.getDataOperationParameterAccess().getImportedComplexTypeAssignment_0_2(), "rule__DataOperationParameter__ImportedComplexTypeAssignment_0_2");
			builder.put(grammarAccess.getDataOperationParameterAccess().getNameAssignment_1(), "rule__DataOperationParameter__NameAssignment_1");
			builder.put(grammarAccess.getPrimitiveValueAccess().getNumericValueAssignment_0(), "rule__PrimitiveValue__NumericValueAssignment_0");
			builder.put(grammarAccess.getPrimitiveValueAccess().getBooleanValueAssignment_1(), "rule__PrimitiveValue__BooleanValueAssignment_1");
			builder.put(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_2(), "rule__PrimitiveValue__StringValueAssignment_2");
			builder.put(grammarAccess.getImportedComplexTypeAccess().getImportAssignment_0(), "rule__ImportedComplexType__ImportAssignment_0");
			builder.put(grammarAccess.getImportedComplexTypeAccess().getImportedTypeAssignment_2(), "rule__ImportedComplexType__ImportedTypeAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private TechnologyDslGrammarAccess grammarAccess;

	@Override
	protected InternalTechnologyDslParser createParser() {
		InternalTechnologyDslParser result = new InternalTechnologyDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TechnologyDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TechnologyDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
