package tp.p2.p3.view;

public class PrinterGenerator {
	private static PrinterTypes types;
	
	public static GamePrinter useStringifier() {
		types = PrinterTypes.STRINGIFIER;
		return types.getObject();
	}
	
	public static GamePrinter useBoardPrinter() {
		types = PrinterTypes.BOARDPRINTER;
		return types.getObject();
	}
	
}
