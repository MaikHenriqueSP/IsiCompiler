// Generated from /media/maik/B4FA6A2DFA69EC54/Users/Windows  7/Desktop/UFABC/12° QUAD - LOADING/Compiladores - Isidro/Projeto/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, AP=12, FP=13, ATR=14, OP=15, NUM=16, OPREL=17, AC=18, 
		FC=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", "AC", "FC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "','", "'.'", "'leia'", 
			"'escreva'", "'se'", "'entao'", "'senao'", null, "'('", "')'", "':='", 
			null, null, null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"AP", "FP", "ATR", "OP", "NUM", "OPREL", "AC", "FC"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public IsiLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\7\fe\n\f\f"+
		"\f\16\fh\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\6\21t\n"+
		"\21\r\21\16\21u\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0081"+
		"\n\22\3\23\3\23\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\7\3\2c|\5\2"+
		"\62;C\\c|\5\2,-//\61\61\3\2\62;\4\2>>@@\2\u008b\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\3)\3\2\2\2\5\62\3\2\2\2\7:\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3"+
		"\2\2\2\17K\3\2\2\2\21S\3\2\2\2\23V\3\2\2\2\25\\\3\2\2\2\27b\3\2\2\2\31"+
		"i\3\2\2\2\33k\3\2\2\2\35m\3\2\2\2\37p\3\2\2\2!s\3\2\2\2#\u0080\3\2\2\2"+
		"%\u0082\3\2\2\2\'\u0084\3\2\2\2)*\7r\2\2*+\7t\2\2+,\7q\2\2,-\7i\2\2-."+
		"\7t\2\2./\7c\2\2/\60\7o\2\2\60\61\7c\2\2\61\4\3\2\2\2\62\63\7h\2\2\63"+
		"\64\7k\2\2\64\65\7o\2\2\65\66\7r\2\2\66\67\7t\2\2\678\7q\2\289\7i\2\2"+
		"9\6\3\2\2\2:;\7f\2\2;<\7g\2\2<=\7e\2\2=>\7n\2\2>?\7c\2\2?@\7t\2\2@A\7"+
		"g\2\2A\b\3\2\2\2BC\7.\2\2C\n\3\2\2\2DE\7\60\2\2E\f\3\2\2\2FG\7n\2\2GH"+
		"\7g\2\2HI\7k\2\2IJ\7c\2\2J\16\3\2\2\2KL\7g\2\2LM\7u\2\2MN\7e\2\2NO\7t"+
		"\2\2OP\7g\2\2PQ\7x\2\2QR\7c\2\2R\20\3\2\2\2ST\7u\2\2TU\7g\2\2U\22\3\2"+
		"\2\2VW\7g\2\2WX\7p\2\2XY\7v\2\2YZ\7c\2\2Z[\7q\2\2[\24\3\2\2\2\\]\7u\2"+
		"\2]^\7g\2\2^_\7p\2\2_`\7c\2\2`a\7q\2\2a\26\3\2\2\2bf\t\2\2\2ce\t\3\2\2"+
		"dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\30\3\2\2\2hf\3\2\2\2ij\7*\2"+
		"\2j\32\3\2\2\2kl\7+\2\2l\34\3\2\2\2mn\7<\2\2no\7?\2\2o\36\3\2\2\2pq\t"+
		"\4\2\2q \3\2\2\2rt\t\5\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2v\""+
		"\3\2\2\2w\u0081\t\6\2\2xy\7>\2\2y\u0081\7?\2\2z{\7@\2\2{\u0081\7?\2\2"+
		"|}\7#\2\2}\u0081\7?\2\2~\177\7?\2\2\177\u0081\7?\2\2\u0080w\3\2\2\2\u0080"+
		"x\3\2\2\2\u0080z\3\2\2\2\u0080|\3\2\2\2\u0080~\3\2\2\2\u0081$\3\2\2\2"+
		"\u0082\u0083\7}\2\2\u0083&\3\2\2\2\u0084\u0085\7\177\2\2\u0085(\3\2\2"+
		"\2\7\2dfu\u0080\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}