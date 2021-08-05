// Generated from /media/maik/B4FA6A2DFA69EC54/Users/Windows  7/Desktop/UFABC/12° QUAD - LOADING/Compiladores - Isidro/Projeto/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8
package parser;

    import datastructures.*;
    import exceptions.*;
    import util.*;

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
		T__9=10, TIPO=11, ID=12, AP=13, FP=14, ATR=15, OP=16, NUM=17, OPREL=18, 
		LOP=19, AC=20, FC=21, WS=22, FIM=23, VIR=24, SEMICOLON=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "TIPO", "ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", "LOP", 
			"AC", "FC", "WS", "FIM", "VIR", "SEMICOLON"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'leia'", "'escreva'", "'se'", "'entao'", 
			"'senao se'", "'senao'", "'enquanto'", "'para'", null, null, "'('", "')'", 
			"':='", null, null, null, null, "'{'", "'}'", null, "'.'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "TIPO", 
			"ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", "LOP", "AC", "FC", "WS", 
			"FIM", "VIR", "SEMICOLON"
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


	    private IsiType type;
	    private String name;
	    private String value;
	    private IsiSymbolTable symbolTable = new IsiSymbolTable();
	    private IsiSymbol symbol;

	    public void addSymbol(String id, IsiType type, String value) {
	        if (symbolTable.contains(id)) {
	            throw new IsiSemanticException("Symbol '" + id + "' already declared.");
	        }

	        IsiSymbol newSymbol = new IsiVariable(id, type, value);
	        symbolTable.add(newSymbol);        
	    }

	    public void verifySymbolDeclaration(String id) {
	        if (!symbolTable.contains(id)) {
	            throw new IsiSemanticException("Symbol '" + id + "' wasn't declared.");            
	        }
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0085\n"+
		"\f\3\r\3\r\7\r\u0089\n\r\f\r\16\r\u008c\13\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\22\6\22\u0098\n\22\r\22\16\22\u0099\3\22\3\22\6"+
		"\22\u009e\n\22\r\22\16\22\u009f\5\22\u00a2\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u00ad\n\23\3\24\3\24\3\24\3\24\5\24\u00b3"+
		"\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\b"+
		"\3\2c|\5\2\62;C\\c|\5\2,-//\61\61\3\2\62;\4\2>>@@\5\2\13\f\17\17\"\"\2"+
		"\u00cb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5>\3\2\2\2\7F\3\2\2\2"+
		"\tK\3\2\2\2\13S\3\2\2\2\rV\3\2\2\2\17\\\3\2\2\2\21e\3\2\2\2\23k\3\2\2"+
		"\2\25t\3\2\2\2\27\u0084\3\2\2\2\31\u0086\3\2\2\2\33\u008d\3\2\2\2\35\u008f"+
		"\3\2\2\2\37\u0091\3\2\2\2!\u0094\3\2\2\2#\u0097\3\2\2\2%\u00ac\3\2\2\2"+
		"\'\u00b2\3\2\2\2)\u00b4\3\2\2\2+\u00b6\3\2\2\2-\u00b8\3\2\2\2/\u00bc\3"+
		"\2\2\2\61\u00be\3\2\2\2\63\u00c0\3\2\2\2\65\66\7r\2\2\66\67\7t\2\2\67"+
		"8\7q\2\289\7i\2\29:\7t\2\2:;\7c\2\2;<\7o\2\2<=\7c\2\2=\4\3\2\2\2>?\7h"+
		"\2\2?@\7k\2\2@A\7o\2\2AB\7r\2\2BC\7t\2\2CD\7q\2\2DE\7i\2\2E\6\3\2\2\2"+
		"FG\7n\2\2GH\7g\2\2HI\7k\2\2IJ\7c\2\2J\b\3\2\2\2KL\7g\2\2LM\7u\2\2MN\7"+
		"e\2\2NO\7t\2\2OP\7g\2\2PQ\7x\2\2QR\7c\2\2R\n\3\2\2\2ST\7u\2\2TU\7g\2\2"+
		"U\f\3\2\2\2VW\7g\2\2WX\7p\2\2XY\7v\2\2YZ\7c\2\2Z[\7q\2\2[\16\3\2\2\2\\"+
		"]\7u\2\2]^\7g\2\2^_\7p\2\2_`\7c\2\2`a\7q\2\2ab\7\"\2\2bc\7u\2\2cd\7g\2"+
		"\2d\20\3\2\2\2ef\7u\2\2fg\7g\2\2gh\7p\2\2hi\7c\2\2ij\7q\2\2j\22\3\2\2"+
		"\2kl\7g\2\2lm\7p\2\2mn\7s\2\2no\7w\2\2op\7c\2\2pq\7p\2\2qr\7v\2\2rs\7"+
		"q\2\2s\24\3\2\2\2tu\7r\2\2uv\7c\2\2vw\7t\2\2wx\7c\2\2x\26\3\2\2\2yz\7"+
		"p\2\2z{\7w\2\2{|\7o\2\2|}\7g\2\2}~\7t\2\2~\u0085\7q\2\2\177\u0080\7v\2"+
		"\2\u0080\u0081\7g\2\2\u0081\u0082\7z\2\2\u0082\u0083\7v\2\2\u0083\u0085"+
		"\7q\2\2\u0084y\3\2\2\2\u0084\177\3\2\2\2\u0085\30\3\2\2\2\u0086\u008a"+
		"\t\2\2\2\u0087\u0089\t\3\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\32\3\2\2\2\u008c\u008a\3\2\2"+
		"\2\u008d\u008e\7*\2\2\u008e\34\3\2\2\2\u008f\u0090\7+\2\2\u0090\36\3\2"+
		"\2\2\u0091\u0092\7<\2\2\u0092\u0093\7?\2\2\u0093 \3\2\2\2\u0094\u0095"+
		"\t\4\2\2\u0095\"\3\2\2\2\u0096\u0098\t\5\2\2\u0097\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a1\3\2"+
		"\2\2\u009b\u009d\7\60\2\2\u009c\u009e\t\5\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2"+
		"\2\2\u00a1\u009b\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2$\3\2\2\2\u00a3\u00ad"+
		"\t\6\2\2\u00a4\u00a5\7>\2\2\u00a5\u00ad\7?\2\2\u00a6\u00a7\7@\2\2\u00a7"+
		"\u00ad\7?\2\2\u00a8\u00a9\7#\2\2\u00a9\u00ad\7?\2\2\u00aa\u00ab\7?\2\2"+
		"\u00ab\u00ad\7?\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a6"+
		"\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad&\3\2\2\2\u00ae"+
		"\u00af\7(\2\2\u00af\u00b3\7(\2\2\u00b0\u00b1\7~\2\2\u00b1\u00b3\7~\2\2"+
		"\u00b2\u00ae\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3(\3\2\2\2\u00b4\u00b5\7"+
		"}\2\2\u00b5*\3\2\2\2\u00b6\u00b7\7\177\2\2\u00b7,\3\2\2\2\u00b8\u00b9"+
		"\t\7\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b\27\2\2\u00bb.\3\2\2\2\u00bc"+
		"\u00bd\7\60\2\2\u00bd\60\3\2\2\2\u00be\u00bf\7.\2\2\u00bf\62\3\2\2\2\u00c0"+
		"\u00c1\7=\2\2\u00c1\64\3\2\2\2\13\2\u0084\u0088\u008a\u0099\u009f\u00a1"+
		"\u00ac\u00b2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}