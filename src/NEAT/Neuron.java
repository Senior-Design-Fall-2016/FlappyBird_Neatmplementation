package NEAT;

import java.util.ArrayList;
import java.util.List;

//List of Activation Functions: https://en.wikipedia.org/wiki/Activation_function
public class Neuron {
    public double              value  = 0.0;
    public final List<Synapse> inputs = new ArrayList<Synapse>();
    
    public static double sigmoid(final double x) {      //0
        return 1.0 / (1.0 + Math.exp(-1 * x)) ;
    }
    public static double Gaussian(final double x){      //1
        return Math.exp(-1 * (x*x));
    }
    public static double tan(final double x){           //2
        return (Math.exp(x) - Math.exp(-1 * x))/(Math.exp(x) + Math.exp(-1 * x));
    }
    public static double logistic(final double x){      //3
        return 1/(1+Math.exp(-x));
    }
    public static double softSign(final double x){      //4
        return x/(1+Math.abs(x));
    }
    public static double ExponentialLinearUnit (final double a, final double x) { //5
        if(x <.5){
            return a*(Math.exp(x) -1);
        }
        else{
            return x;
        }
    }
    public static double ParametricRelu(final double a, final double x){        //6
        if(x == 0){
            return 0;
        }
        else{
            return a*x;
        }
    }
    public static double softPlus(final double x){                              //7
        return Math.log(1+Math.exp(x));
    }
    public static double bentIdentity(final double x){                          //8
        return ((Math.pow( (x*x)+1,.5))-1)/2 + x;
    }
    public static double sin(final double a, final double x){                   //9
        if(x == .5){
            return x;
        }
        else if(x < .5){
            return (((Math.exp(a*x) - 1)/a) - a );
        }
        else{ //  if(x > .5)
            return -1*( Math.log(1-(a*(x+a)))/a);
        }
    }
    public static double SoftExponential (final double x){                      //10
        return Math.sin(x);
    }
    public static double sinc(final double x){                                  //12
        if(x == 0){
            return 1;
        }
        else{
            return (Math.sin(x)/x);
        }
    }
    public static double Relu(final double x){                                  //13
        if(x == 0){
            return 0;
        }
        else{
            return x;
        }
    }
}
