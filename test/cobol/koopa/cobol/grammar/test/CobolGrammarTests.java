package koopa.cobol.grammar.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.CobolProject;
import koopa.cobol.CobolTokens;
import koopa.cobol.projects.BasicCobolProject;
import koopa.cobol.sources.SourceFormat;
import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.stage.runtime.GrammarTestSuite;
import koopa.dsl.stage.util.StageUtil;

public class CobolGrammarTests extends GrammarTestSuite {

	private final CobolProject project = new BasicCobolProject();

	public CobolGrammarTests() {
		project.setDefaultFormat(SourceFormat.FREE);
	}

	public File[] getStageFiles() {
		return new File("test/cobol/koopa/cobol/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}

	public Grammar getGrammar() {
		return project.getGrammar();
	}

	public Source getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);
		return CobolTokens.getNewSource(reader, project);
	}
}
