package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.AC3Strategy;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Assignment;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.CSP;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.CspHeuristics;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Domain;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.InferenceLog;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.InferenceStrategy;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Variable;

/**
 * This backtracking search implementation can be configured with arbitrary
 * strategies for variable selection, value ordering, and inference. These
 * strategies are represented by objects implementing standard interfaces. The
 * design supports experiments with user-defined strategies of all kinds.
 *
 * @param <VAR> Type which is used to represent variables
 * @param <VAL> Type which is used to represent the values in the domains
 *
 * @author Ruediger Lunde
 */
public class FlexibleBacktrackingSolver<VAR extends Variable, VAL> extends AbstractBacktrackingSolver<VAR, VAL> {

	private CspHeuristics.VariableSelectionStrategy<VAR, VAL> varSelectionStrategy;
	private CspHeuristics.ValueOrderingStrategy<VAR, VAL> valOrderingStrategy;
	private InferenceStrategy<VAR, VAL> inferenceStrategy;

	/**
	 * Selects the algorithm for SELECT-UNASSIGNED-VARIABLE. Uses the fluent
	 * interface design pattern.
	 */
	public FlexibleBacktrackingSolver<VAR, VAL> set(CspHeuristics.VariableSelectionStrategy<VAR, VAL> varStrategy) {
		varSelectionStrategy = varStrategy;
		return this;
	}

	/**
	 * Selects the algorithm for ORDER-DOMAIN-VALUES. Uses the fluent interface
	 * design pattern.
	 */
	public FlexibleBacktrackingSolver<VAR, VAL> set(CspHeuristics.ValueOrderingStrategy<VAR, VAL> valStrategy) {
		valOrderingStrategy = valStrategy;
		return this;
	}

	/**
	 * Selects the algorithm for INFERENCE. Uses the fluent interface design
	 * pattern.
	 */
	public FlexibleBacktrackingSolver<VAR, VAL> set(InferenceStrategy<VAR, VAL> iStrategy) {
		inferenceStrategy = iStrategy;
		return this;
	}

	/**
	 * Selects MRV&DEG for variable selection, LCV for domain ordering and AC3 as
	 * inference method.
	 */
	public FlexibleBacktrackingSolver<VAR, VAL> setAll() {
		return set(CspHeuristics.mrvDeg()).set(CspHeuristics.lcv()).set(new AC3Strategy<>());
	}

	/**
	 * Applies an initial inference step and then calls the super class
	 * implementation.
	 */
	@Override
	public Optional<Assignment<VAR, VAL>> solve(CSP<VAR, VAL> csp, HashMap<Variable, String> caso) {
		if (inferenceStrategy != null) {
			csp = csp.copyDomains(); // do not change the original CSP!
			InferenceLog log = inferenceStrategy.apply(csp);
			if (!log.isEmpty()) {
				fireStateChanged(csp, null, null);
				if (log.inconsistencyFound())
					return Optional.empty();
			}
		}
		return super.solve(csp, caso);
	}

	/**
	 * Primitive operation, selecting a not yet assigned variable.
	 */
	@Override
	protected VAR selectUnassignedVariable(CSP<VAR, VAL> csp, Assignment<VAR, VAL> assignment) {
		List<VAR> vars = csp.getVariables().stream().filter(v -> !assignment.contains(v)).collect(Collectors.toList());
		if (varSelectionStrategy != null)
			vars = varSelectionStrategy.apply(csp, vars);
		return vars.get(0);
	}

	/**
	 * Primitive operation, ordering the domain values of the specified variable.
	 */
	@Override
	protected Iterable<VAL> orderDomainValues(CSP<VAR, VAL> csp, Assignment<VAR, VAL> assignment, VAR var) {
		return (valOrderingStrategy != null) ? valOrderingStrategy.apply(csp, assignment, var)
				: sortDominios(csp.getDomain(var));
	}

	private Iterable<VAL> sortDominios(Domain<VAL> dominios) {
		return dominios.asList().stream().sorted((dominio1, dominio2) -> compare(dominio1, dominio2))
				.collect(Collectors.toList());
	}
        // CARGA HORARIA <= HORARIOS PREFERENCIAS
        // 
	private int compare(VAL bf, VAL bt) {
		if (MapHorario.TRABALHA.equals(bf)) {
			return -1;
		} else if (MapHorario.TRABALHA.equals(bt)) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Primitive operation, which tries to optimize the CSP representation with
	 * respect to a new assignment.
	 *
	 * @param var The variable which just got a new value in the assignment.
	 * @return An object which provides information about (1) whether changes have
	 *         been performed, (2) possibly inferred empty domains, and (3) how to
	 *         restore the original CSP.
	 */
	@Override
	protected InferenceLog<VAR, VAL> inference(CSP<VAR, VAL> csp, Assignment<VAR, VAL> assignment, VAR var) {
		return (inferenceStrategy != null) ? inferenceStrategy.apply(csp, assignment, var) : InferenceLog.emptyLog();
	}

}
