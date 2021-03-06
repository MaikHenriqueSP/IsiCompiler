// Generated from /Users/andreyoshdia/Documents/ufabc/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8

    import datastructures.*;
    import exceptions.*;
    import ast.*;
    import util.*;
    import java.util.*;

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
		T__9=10, T__10=11, T__11=12, ID=13, AP=14, FP=15, ATR=16, OP=17, NUM=18, 
		TEXT=19, CMT=20, OPREL=21, LOP=22, AC=23, FC=24, WS=25, FIM=26, VIR=27, 
		SEMICOLON=28, UNARY=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ID", "AP", "FP", "ATR", "OP", "NUM", "TEXT", 
			"CMT", "OPREL", "LOP", "AC", "FC", "WS", "FIM", "VIR", "SEMICOLON", "UNARY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao'", "'enquanto'", "'para'", "'faca'", null, 
			"'('", "')'", "':='", null, null, null, null, null, null, "'{'", "'}'", 
			null, "'.'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "AP", "FP", "ATR", "OP", "NUM", "TEXT", "CMT", "OPREL", "LOP", 
			"AC", "FC", "WS", "FIM", "VIR", "SEMICOLON", "UNARY"
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
	    private String value;
	    private IsiSymbolTable symbolTable = new IsiSymbolTable();
	    private IsiSymbol symbol;

	    private String _test;
	    
	    private String currentID;
	    private String content;
	    private IsiProgram program = new IsiProgram();
	    private List<AbstractCommand> currentThread;
	    private Stack<List<AbstractCommand>> stack = new Stack<>();

	    private List<AbstractCommand> trueList;
	    private List<AbstractCommand> falseList;

	    // Start - Unary operations related
	    private boolean isPostUnary;
	    // End - Unary operations related

	    // Start - Expression validation related
	    private List<IsiType> expressionTypes;
	    private List<String> mathOperators;
	    private IsiType expressionIsiType;
	    private String assigningVariableID;

	    public void setExpressionType() {
	        if (expressionTypes.contains(IsiType.TEXT)) {
	            expressionIsiType = IsiType.TEXT;
	            return;
	        }
	        expressionIsiType = IsiType.NUMBER;
	    }

	    public void verifyAssignmentType() {
	        IsiType variableType = getSymbolType(assigningVariableID);
	        if (variableType != expressionIsiType) {
	            throw new IsiSemanticException("Can't assign '" + expressionIsiType + "' to a '" + variableType + "' variable. Variable name: " + assigningVariableID);
	        }
	    }

	    public void verifyOperationValidity() {       
	        if (expressionIsiType == IsiType.NUMBER || mathOperators.size() == 0) {
	            return;
	        }

	        if (mathOperators.contains("-")) {
	            throw new IsiSemanticException("A TEXT expression cannot have a '-' operator.");
	        }

	        for (int i = 1; i < expressionTypes.size(); i++) {
	            if (!mathOperators.get(i -1).equals("+") && (expressionTypes.get(i) == IsiType.TEXT || expressionTypes.get(i - 1) == IsiType.TEXT)) {
	                throw new IsiSemanticException("Invalid operation.");
	            }
	        }
	    }
	    // End - Expression validation related

	    // Start - Loop-for related
	    private String loopForVariables;
	    private String loopForCondition;
	    private String loopForIncrementer;
	    // End - Loop-for related
	    
	    public IsiType getSymbolType(String id) {
	        return ((IsiVariable) symbolTable.get(id)).getType();
	    }

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

	    public void setSymbolToBeInUse(String id) {
	        verifySymbolDeclaration(id);
	        IsiVariable variable = (IsiVariable) symbolTable.get(id);
	        variable.becomeInUse();
	        symbolTable.add(variable);
	    }

	    public void verifyIfAllVariablesAreInUse() {
	        Optional<IsiSymbol> variable = symbolTable.getSymbols().stream().filter(var -> !((IsiVariable) var).getIsBeingUsed()).findFirst();

	        if (variable.isPresent()) {
	            throw new IsiSemanticException("The varible  '" + variable.get().getName() + "' wasn't used.");
	        }
	    }

	    public void verifyType(String id, IsiType type) {
	        if (getSymbolType(id) != type) {
	            throw new IsiSemanticException("The variable is not a " + type);
	        }
	    }

	    public void verifyExpectedExpressionType(IsiType type) {
	        if (expressionIsiType != type) {
	            throw new IsiSemanticException("The variable is not a " + type);
	        }
	    }

	    public void verifyBooleanExpression() {
	        if (expressionIsiType != IsiType.NUMBER) {
	            throw new IsiSemanticException("A boolean expression can only contain subexpressions of type NUMBER");
	        }
	    }


	    public void generateProgram() {
	        program.generateProgram();
	    }

	    public void showCommands() {
	        for (AbstractCommand c : program.getCommands()) {
	            System.out.println(c);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00e0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\7\16\u008d\n\16\f\16\16\16\u0090\13"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\6\23\u009c\n\23"+
		"\r\23\16\23\u009d\3\23\3\23\6\23\u00a2\n\23\r\23\16\23\u00a3\5\23\u00a6"+
		"\n\23\3\24\3\24\3\24\7\24\u00ab\n\24\f\24\16\24\u00ae\13\24\3\24\3\24"+
		"\3\25\3\25\3\25\7\25\u00b5\n\25\f\25\16\25\u00b8\13\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00c5\n\26\3\27\3\27\3\27"+
		"\3\27\5\27\u00cb\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u00df\n\36\2\2\37\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2"+
		"\b\3\2c|\5\2\62;C\\c|\5\2,-//\61\61\3\2\62;\4\2>>@@\5\2\13\f\17\17\"\""+
		"\2\u00ed\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\3=\3\2\2\2\5F\3\2\2\2\7N\3\2\2\2\tU\3\2\2\2\13[\3\2\2"+
		"\2\r`\3\2\2\2\17h\3\2\2\2\21k\3\2\2\2\23q\3\2\2\2\25w\3\2\2\2\27\u0080"+
		"\3\2\2\2\31\u0085\3\2\2\2\33\u008a\3\2\2\2\35\u0091\3\2\2\2\37\u0093\3"+
		"\2\2\2!\u0095\3\2\2\2#\u0098\3\2\2\2%\u009b\3\2\2\2\'\u00a7\3\2\2\2)\u00b1"+
		"\3\2\2\2+\u00c4\3\2\2\2-\u00ca\3\2\2\2/\u00cc\3\2\2\2\61\u00ce\3\2\2\2"+
		"\63\u00d0\3\2\2\2\65\u00d4\3\2\2\2\67\u00d6\3\2\2\29\u00d8\3\2\2\2;\u00de"+
		"\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7q\2\2@A\7i\2\2AB\7t\2\2BC\7c\2\2CD\7o\2"+
		"\2DE\7c\2\2E\4\3\2\2\2FG\7h\2\2GH\7k\2\2HI\7o\2\2IJ\7r\2\2JK\7t\2\2KL"+
		"\7q\2\2LM\7i\2\2M\6\3\2\2\2NO\7p\2\2OP\7w\2\2PQ\7o\2\2QR\7g\2\2RS\7t\2"+
		"\2ST\7q\2\2T\b\3\2\2\2UV\7v\2\2VW\7g\2\2WX\7z\2\2XY\7v\2\2YZ\7q\2\2Z\n"+
		"\3\2\2\2[\\\7n\2\2\\]\7g\2\2]^\7k\2\2^_\7c\2\2_\f\3\2\2\2`a\7g\2\2ab\7"+
		"u\2\2bc\7e\2\2cd\7t\2\2de\7g\2\2ef\7x\2\2fg\7c\2\2g\16\3\2\2\2hi\7u\2"+
		"\2ij\7g\2\2j\20\3\2\2\2kl\7g\2\2lm\7p\2\2mn\7v\2\2no\7c\2\2op\7q\2\2p"+
		"\22\3\2\2\2qr\7u\2\2rs\7g\2\2st\7p\2\2tu\7c\2\2uv\7q\2\2v\24\3\2\2\2w"+
		"x\7g\2\2xy\7p\2\2yz\7s\2\2z{\7w\2\2{|\7c\2\2|}\7p\2\2}~\7v\2\2~\177\7"+
		"q\2\2\177\26\3\2\2\2\u0080\u0081\7r\2\2\u0081\u0082\7c\2\2\u0082\u0083"+
		"\7t\2\2\u0083\u0084\7c\2\2\u0084\30\3\2\2\2\u0085\u0086\7h\2\2\u0086\u0087"+
		"\7c\2\2\u0087\u0088\7e\2\2\u0088\u0089\7c\2\2\u0089\32\3\2\2\2\u008a\u008e"+
		"\t\2\2\2\u008b\u008d\t\3\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\34\3\2\2\2\u0090\u008e\3\2\2"+
		"\2\u0091\u0092\7*\2\2\u0092\36\3\2\2\2\u0093\u0094\7+\2\2\u0094 \3\2\2"+
		"\2\u0095\u0096\7<\2\2\u0096\u0097\7?\2\2\u0097\"\3\2\2\2\u0098\u0099\t"+
		"\4\2\2\u0099$\3\2\2\2\u009a\u009c\t\5\2\2\u009b\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a5\3\2\2\2\u009f"+
		"\u00a1\7\60\2\2\u00a0\u00a2\t\5\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3"+
		"\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u009f\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6&\3\2\2\2\u00a7\u00ac\7$\2\2\u00a8"+
		"\u00ab\t\3\2\2\u00a9\u00ab\5\63\32\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3"+
		"\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7$\2\2\u00b0(\3\2\2\2\u00b1"+
		"\u00b6\7%\2\2\u00b2\u00b5\t\3\2\2\u00b3\u00b5\5\63\32\2\u00b4\u00b2\3"+
		"\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7%"+
		"\2\2\u00ba*\3\2\2\2\u00bb\u00c5\t\6\2\2\u00bc\u00bd\7>\2\2\u00bd\u00c5"+
		"\7?\2\2\u00be\u00bf\7@\2\2\u00bf\u00c5\7?\2\2\u00c0\u00c1\7#\2\2\u00c1"+
		"\u00c5\7?\2\2\u00c2\u00c3\7?\2\2\u00c3\u00c5\7?\2\2\u00c4\u00bb\3\2\2"+
		"\2\u00c4\u00bc\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c5,\3\2\2\2\u00c6\u00c7\7(\2\2\u00c7\u00cb\7(\2\2\u00c8\u00c9"+
		"\7~\2\2\u00c9\u00cb\7~\2\2\u00ca\u00c6\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		".\3\2\2\2\u00cc\u00cd\7}\2\2\u00cd\60\3\2\2\2\u00ce\u00cf\7\177\2\2\u00cf"+
		"\62\3\2\2\2\u00d0\u00d1\t\7\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\32\2"+
		"\2\u00d3\64\3\2\2\2\u00d4\u00d5\7\60\2\2\u00d5\66\3\2\2\2\u00d6\u00d7"+
		"\7.\2\2\u00d78\3\2\2\2\u00d8\u00d9\7=\2\2\u00d9:\3\2\2\2\u00da\u00db\7"+
		"-\2\2\u00db\u00df\7-\2\2\u00dc\u00dd\7/\2\2\u00dd\u00df\7/\2\2\u00de\u00da"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00df<\3\2\2\2\17\2\u008c\u008e\u009d\u00a3"+
		"\u00a5\u00aa\u00ac\u00b4\u00b6\u00c4\u00ca\u00de\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}