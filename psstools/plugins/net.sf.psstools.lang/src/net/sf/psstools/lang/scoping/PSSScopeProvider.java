/*
 * generated by Xtext 2.12.0
 */
package net.sf.psstools.lang.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import net.sf.psstools.lang.pSS.PSSPackage;
import net.sf.psstools.lang.pSS.component_declaration;
import net.sf.psstools.lang.pSS.component_super_spec;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class PSSScopeProvider extends AbstractPSSScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		System.out.println("getScope: context=" + context + " reference=" + reference);
		if (context instanceof component_super_spec) {
		EObject rootElement = EcoreUtil2.getRootContainer(context);
		System.out.println("rootElement=" + rootElement.eContainer() + " " + rootElement.eResource());
		List<component_declaration> candidates = EcoreUtil2.getAllContentsOfType(
				rootElement, component_declaration.class);
		System.out.println("candidates=" + candidates);
		
//		List<component_declaration> candidate_t = new ArrayList<component_declaration>();
//		for (EObject c : candidates) {
//			val ti = PSSPackage.eINSTANCE.EFactoryInstance.create(PSSPackage.eINSTANCE.gettype_identifier()) as type_identifier;
//			ti.elems.add(c.name);
//			candidate_t.add(ti)
//		}
		
	
//		val existingScope = Scopes.scopeFor(candidate_t);
//		
//		//return new FilteringScope(existingScope, [getEObjectOrProxy != context]);	
//		return existingScope		
		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();
		for (component_declaration d : candidates) {
			EObjectDescription desc = new EObjectDescription(
					QualifiedName.create(d.getName()),
					d, null);
			descriptions.add(desc);
			System.out.println("Desc: " + d);
		}
				
//		SimpleScope s = new SimpleScope(descriptions);
		IScope s =  Scopes.scopeFor(candidates);
		// TODO Auto-generated method stub
		for (IEObjectDescription d : s.getAllElements()) {
			System.out.println("Object: " + d);
		}
		return s;
		}
		return super.getScope(context, reference);
	}

	public IScope getScope(component_declaration cdecl, EReference reference) {
		System.out.println("getScope(component)\n");
		return super.getScope(cdecl, reference);
	}
	
	public IScope getScope(component_super_spec cdecl, EReference reference) {
		System.out.println("getScope(component_super_spec)\n");
		
		return super.getScope(cdecl, reference);
	}
	
	
//	override getScope(EObject context, EReference reference) {
//		System.out.println("getScope: " + context + " " + reference);
//		val rootE = EcoreUtil2.getRootContainer(context);
//		val rootR = rootE.eResource.contents
//		
//		if (context instanceof action_super_spec) {
//			val action_super_spec ti = context as action_super_spec;
//	
//			val rootElement = EcoreUtil2.getRootContainer(context);
//			System.out.println("rootElement=" + rootElement);
//			val candidates = EcoreUtil2.getAllContentsOfType(rootElement, action_declaration);
//			System.out.println("candidates=" + candidates);
////			return Scopes.sc
//		} else if (context instanceof component_super_spec) {
//			val rootElement = EcoreUtil2.getRootContainer(context);
//			System.out.println("rootElement=" + rootElement.eContainer + " " + rootElement.eResource);
//			val candidates = EcoreUtil2.getAllContentsOfType(rootElement, component_declaration);
//			System.out.println("candidates=" + candidates);
//			
//			val candidate_t = new ArrayList<type_identifier>()
//			for (c : candidates) {
//				val ti = PSSPackage.eINSTANCE.EFactoryInstance.create(PSSPackage.eINSTANCE.gettype_identifier()) as type_identifier;
//				ti.elems.add(c.name);
//				candidate_t.add(ti)
//			}
//			
//		
//			val existingScope = Scopes.scopeFor(candidate_t);
//			
//			//return new FilteringScope(existingScope, [getEObjectOrProxy != context]);	
//			return existingScope
//		} else {
//			
//		}
//		return super.getScope(context, reference);
//	}
}
