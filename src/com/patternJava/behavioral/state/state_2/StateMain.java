package com.patternJava.behavioral.state.state_2;
/*
1) інтерфейс PackageState#updateState(DeliveryContext ctx)
   = 4 імплементації, де ми кожного разу працюємо з контексним класом
   
2) контексний клас DeliveryContext через анрегацію має поле цього PackageState   
   у цьому ж класі 
       public void update() {
        currentState.updateState(this);
    }
    
    викликаючи цей метод ми делегуємо PackageState#updateState, куди параметром 
    передаємо сам контекст
    
3) так викликаючи цей метод на контексті ми змінюємо стан самого контексту, 
   бо знаємо, що кожна імплементація PackageState встановлює наступний свій стан     

 */
public class StateMain {
    public static void main(String[] args) {
        DeliveryContext ctx = new DeliveryContext(new Acknowledged(), "Test123");

        ctx.update(); // Package is acknowledged !!
        ctx.update(); // Package is shipped !!
        ctx.update(); // Package is in transition !!
        ctx.update(); // Package is delivered!!
    }
}
