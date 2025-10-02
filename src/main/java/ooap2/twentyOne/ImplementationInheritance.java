package ooap2.twentyOne;

public class ImplementationInheritance {
    public static void main(String[] args) {
        var internalLogProcessor = new InternalLogProcessor(13);
        System.out.println(internalLogProcessor.process());

        var ilProcessor = new InternalLogAndPrintProcessor(13);
        ilProcessor.process();

    }
}

class InternalLogProcessor {

    protected int parameter;

    public InternalLogProcessor(int parameter) {
        this.parameter = parameter;
    }

    public double process() {
        return Math.log(parameter);
    }
}

class InternalLogAndPrintProcessor extends InternalLogProcessor {

    public InternalLogAndPrintProcessor(int parameter) {
        super(parameter);
    }

    public double process() {
        var res = super.process();
        System.out.println(res);
        return res;
    }
}
