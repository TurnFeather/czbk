package cn.edu.ncist.dataAnalyze.realtime.rules;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import cn.edu.ncist.dataAnalyze.realtime.vo.AccidentModel;
import cn.edu.ncist.dataAnalyze.realtime.vo.RuleModel;

public class Accident {
	public void check(AccidentModel accidentmodel){
		KnowledgeBase kbase = getKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "ksession");

		ksession.insert(accidentmodel);
		ksession.fireAllRules();
		logger.close();
	}

	private KnowledgeBase getKnowledgeBase() {
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

//		kbuilder.add(ResourceFactory.newClassPathResource("F:\\MyEclipse\\WorkSpace\\DataAnalyze\\src\\cn\\edu\\ncist\\dataAnalyze\\rules\\Rule.drl"), ResourceType.DRL);
		kbuilder.add(ResourceFactory.newClassPathResource("Accident.drl"), ResourceType.DRL);
//		kbuilder.add(ResourceFactory.newFileResource("cn.edu.ncist.dataAnalyze.realtime.rules.test.drl"), ResourceType.DRL);
		
			
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if(errors.size()>0){
			for(KnowledgeBuilderError error : errors){
				System.out.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();

		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		
		return kbase;
	}
	

}
