package com.example.c2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick_1(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("1");
        }else{
            textView.setText(textView.getText().toString()+"1");
        }
    }
    public void onButtonClick_2(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("2");
        }else{
            textView.setText(textView.getText().toString()+"2");
        }
    }
    public void onButtonClick_3(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("3");
        }else{
            textView.setText(textView.getText().toString()+"3");
        }

    }
    public void onButtonClick_4(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("4");
        }else{
            textView.setText(textView.getText().toString()+"4");
        }
    }
    public void onButtonClick_5(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("5");
        }else{
            textView.setText(textView.getText().toString()+"5");
        }
    }
    public void onButtonClick_6(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("6");
        }else{
            textView.setText(textView.getText().toString()+"6");
        }
    }
    public void onButtonClick_7(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("7");
        }else{
            textView.setText(textView.getText().toString()+"7");
        }
    }
    public void onButtonClick_8(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("8");
        }else{
            textView.setText(textView.getText().toString()+"8");
        }
    }
    public void onButtonClick_9(View view) {
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")){
            textView.setText("9");
        }else{
            textView.setText(textView.getText().toString()+"9");
        }
    }

    public void onButtonClick_0(View view){
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")==false){
            textView.setText(textView.getText().toString()+"0");
        }
    }

    public void onButtonClick_00(View view){
        TextView textView =findViewById(R.id.textView1);
        if(textView.getText().equals("0")==false){
            textView.setText(textView.getText().toString()+"00");
        }
    }

    public void onButtonClick_add(View view){
        TextView textView =findViewById(R.id.textView1);
        String a = "" + textView.getText().toString().charAt(textView.getText().length()-1);
        if(!(a.equals("÷") || a.equals("x") || a.equals("+") || a.equals("-"))){
            textView.setText(textView.getText().toString()+"+");
        }
    }

    public void onButtonClick_sub(View view){
        TextView textView =findViewById(R.id.textView1);
        String a = "" + textView.getText().toString().charAt(textView.getText().length()-1);
        if(!(a.equals("÷") || a.equals("x") || a.equals("+") || a.equals("-"))){
            textView.setText(textView.getText().toString()+"-");
        }
    }

    public void onButtonClick_mul(View view){
        TextView textView =findViewById(R.id.textView1);
        String a = "" + textView.getText().toString().charAt(textView.getText().length()-1);
        if(!(a.equals("÷") || a.equals("x") || a.equals("+") || a.equals("-"))){
            textView.setText(textView.getText().toString()+"x");
        }
    }

    public void onButtonClick_divide(View view){
        TextView textView =findViewById(R.id.textView1);
        String a = "" + textView.getText().toString().charAt(textView.getText().length()-1);
        if(!(a.equals("÷") || a.equals("x") || a.equals("+") || a.equals("-"))){
            textView.setText(textView.getText().toString()+"÷");
        }
    }

    public void onButtonClick_point(View view){
        TextView textView =findViewById(R.id.textView1);
        String a = "" + textView.getText().toString().charAt(textView.getText().length()-1);
        if(a.equals(".")==false && a.equals("+")==false && a.equals("-")==false && a.equals("x")==false && a.equals("÷")==false ){
            textView.setText(textView.getText().toString()+".");
        }

    }

    public void onButtonClick_clear(View view){
        TextView textView =findViewById(R.id.textView1);
        textView.setText("0");
    }

    public void onButtonClick_back(View view){
        TextView textView =findViewById(R.id.textView1);
        if(!textView.toString().equals("0")){
            String currentText = textView.getText().toString();  //获取当前文本编辑框的内容
            if (TextUtils.isEmpty(textView.getText())) { //如果textView中文本为空，不进行操作
                return;
            }
            textView.setText(currentText.substring(0, currentText.length() - 1).length() > 0 ? currentText.substring(0, currentText.length() - 1) : "0");  //删除最后一个字符
        }
    }

    public void onButtonClick_percent(View view){
        TextView textView = findViewById(R.id.textView1);
        String a = "" + textView.getText().toString().charAt(textView.getText().length()-1);
        if(!(a.equals(".") || a.equals("+") || a.equals("-") || a.equals("x") || a.equals("÷"))){
            textView.setText(textView.getText().toString()+"%");
        }
    }

    public void onButtonClick_den(View view) {
        TextView textView =findViewById(R.id.textView1);
        String infix ="";  //中缀表达式
        infix = textView.getText().toString();
        StringBuffer postfix = InfixToPostfix(infix);
        double result = PostfixToValue(postfix);
        textView.setText(""+result);
    }
    //将infix中缀表达式转换成postfix后缀表达式
    static StringBuffer InfixToPostfix(String infix) {

        SeqStack<String> stack = new SeqStack<String>(infix.length());  //运算符栈（顺序）

        StringBuffer postfix = new StringBuffer(infix.length()*2);  //后缀表达式字符串

        int i = 0;  //字符串元素下标
        String tran = ""; //用于转换%
        int k = 0;
        while(k<infix.length()) {  //将%转化为/100
            char ch = infix.charAt(k);
            if(ch == '%')
                tran += "/100";
            else tran += ch + "";
            k++;
        }
        infix = tran;
        while(i<infix.length()) {

            char ch = infix.charAt(i);

            switch(ch) {

                case '+': case'-':  //遇到+、-运算符
                    while(!stack.isEmpty()){  //当运算符栈顶元素不为空
                        postfix.append(stack.pop());  //将栈顶元素添加到后缀表达式串
                    }
                    stack.push(ch+"");
                    i++; break;

                case 'x': case'÷':  //遇到*、/运算符
                    while(!stack.isEmpty() && (stack.peek().equals("x") || stack.peek().equals("÷"))){
                        postfix.append(stack.pop());  //栈顶优先级高的运算符出栈
                    }
                    stack.push(ch+"");
                    i++; break;

                default :  //遇到数字，添加到后缀表达式
                    while(i<infix.length() && ((ch>='0' && ch <='9') || ch == '.')) {
                        postfix.append(ch);
                        i++;
                        if(i<infix.length())
                            ch = infix.charAt(i);
                    }
                    postfix.append(" ");  //添加空格作为数字之间的分隔符
            }
        }
        while(!stack.isEmpty()) { //所有运算符出栈
            postfix.append(stack.pop());  //添加到postfix串之后  
        }
        return postfix;
    }

    //计算后缀表达式的值
    public static double PostfixToValue(StringBuffer postfix) {
        SeqStack<Double> stack = new SeqStack<Double>();  //操作数栈（顺序）
        double value = 0;
        String str = "";

        for(int i = 00; i < postfix.length(); i++) {  //逐个检查后缀表达式中的字符
            char ch = postfix.charAt(i);
            if((ch >= '0' && ch <= '9') || ch == '.') {  //遇到数字字符
                value = 0;
                while(ch != ' ') {  //将字符串转化为double值
                    str += ch;
                    ch = postfix.charAt(++i);
                }
                value = Double.parseDouble(str);
                str = "";
                stack.push((Double)(value));  //new Integer(value)整数对象入栈
            }

            else if (ch != ' '){
                double y = stack.pop(), x= stack.pop();  //出栈两个操作数，注意出栈次序
                BigDecimal X = new BigDecimal(Double.toString(x));
                BigDecimal Y = new BigDecimal(Double.toString(y));
                switch(ch) {  //根据运算符分别计算
                    case '+':value = (X.add(Y)).doubleValue(); break;
                    case '-':value = (X.subtract(Y)).doubleValue(); break;
                    case 'x':value = (X.multiply(Y)).doubleValue(); break;
                    case '÷':value = (X.divide(Y)).doubleValue(); break;
                }


                stack.push(value);  //运算结果入栈
            }
        }
        return stack.pop();  //返回运算结果
    }

}
class SeqList<T> extends Object {
    protected Object[] element; //对象数组存储顺序表的数据元素，保护成员
    protected int n;  //顺序表元素个数（长度）

    public SeqList(int length) {  //构造容量为length的空表
        this.element = new Object[length];  //申请数组的存储空间，元素为null
        this.n = 0;
    }

    public SeqList() {  //创建默认容量的空表，构造方法重载
        this(64);  //调用本类已声明的指定参数列表的构造方法
    }

    public SeqList(T[] values) {
        this(values.length);  //创建容量为value.length的空表
        for(int i = 0; i < values.length; i ++)  //复制数组元素
            this.element[i] = values[i];

        this.n = element.length;  //
    }

    boolean isEmpty() {  //判断顺序表是否空，若为空则返回true
        return this.n == 0;
    }

    public int size() {  //返回顺序表元素个数
        return this.n;
    }

    public T get(int i) {  //返回第i个元素，0<= i <n。若i越界，则返回null
        if(i >= 0 && i < this.n) {
            return (T)this.element[i];
        }
        return null;
    }

    public void set(int i, T x) {  //设置第i个元素为x
        if(x == null) {
            throw new NullPointerException("x==null");  //抛出空对象异常
        }
        if(i >= 0 && i< this.n) {
            this.element[i] = x;
        }
        else throw new java.lang.IndexOutOfBoundsException(i+"");  //抛出序号越界异常
    }

    public int insert(int i, T x) {  //插入x作为第i个元素
        if(x == null) {
            throw new NullPointerException("x==null");  //抛出空对象异常
        }
        if(i < 0)  i = 0;
        if(i > this.n)  i = this.n;
        Object[] source = this.element;
        if(this.n == element.length) {
            this.element = new Object[this.element.length * 2];
            for(int j = 0 ; j < i; j++) {
                this.element[j+1] = source[j];
            }
        }
        for(int j = this.n-1; j >= i; j --) {
            this.element[j+1] = source[j];
        }
        this.element[i] = x;
        this.n++;
        return i;
    }

    public int insert(T x) {
        this.insert(n, x);
        return n;
    }

    public T remove(int i) {
        if(this.n>0 && i>=0 && i<this.n) {
            T old = (T)this.element[i];
            for(int j=i; j<this.n-1; j++) {
                this.element[j] = this.element[j+1];
            }
            this.element[this.n-1] = null;
            this.n--;
            return old;
        }
        return null;
    }

    public void clear() {
        this.n = 0;
    }

    public String toString() {
        String str = this.getClass().getName()+"(";  //返回类名
        if(this.n > 0) {
            str += this.element[0].toString();
        }
        for(int i = 1; i < this.n; i ++) {
            str += "," + this.element[i].toString();  //执行T类的toString()方法，运行时多态
        }
        return str+")";  //空表返回()
    }
}
class SeqStack<T> {
    private SeqList<T> list;

    public SeqStack() {
        this.list = new SeqList<T>();
    }

    public SeqStack(int length) {
        this.list = new SeqList<T>(length);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void push(T x) {
        this.list.insert(x);
    }

    public T peek() {
        return this.list.get(list.size() - 1);
    }

    public T pop() {
        return list.remove(list.size() - 1);
    }
}




