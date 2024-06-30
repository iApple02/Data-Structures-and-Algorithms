public class CallStack
{
    public static void main(String[] args)
    {
        recursiveFunction();
    }

    static void firstFunction(DSAStack s)
    {
        s.push("Num 1");
        s.printStack();
        s.pop();
    }
    static void secondFunction(DSAStack s)
    {
        s.push("Num 2");
        s.printStack();
        s.pop();
        firstFunction(s);
    }
    static void thirdFunction(DSAStack s)
    {
        s.push("Num 3");
        s.printStack();
        s.pop();
        secondFunction(s);        
    }
    static void recursiveFunction()
    {
        DSAStack s = new DSAStack();
        thirdFunction(s);
    }
}
