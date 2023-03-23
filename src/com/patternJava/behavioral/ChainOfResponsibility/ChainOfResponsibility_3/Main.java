package com.patternJava.behavioral.ChainOfResponsibility.ChainOfResponsibility_3;

public class Main {
    public static void main(String[] args) {
        CustomerSupport customerSupport = new CustomerSupport();

        Request lowPriorityRequest = new Request("Low priority request", Priority.LOW);
        Request mediumPriorityRequest = new Request("Medium priority request", Priority.MEDIUM);
        Request highPriorityRequest = new Request("High priority request", Priority.HIGH);

        customerSupport.processRequest(lowPriorityRequest);
        customerSupport.processRequest(mediumPriorityRequest);
        customerSupport.processRequest(highPriorityRequest);
    }
}

/*
    Advantages of Chain of Responsibility Design Pattern 
        > To reduce the coupling degree. Decoupling it will request the sender and receiver.
        > Simplified object. The object does not need to know the chain structure.
        > Enhance flexibility of object assigned duties. By changing the members within the chain or change their order, 
            allow dynamic adding or deleting responsibility.
        > Increase the request processing new class of very convenient.
    
    DisAdvantages of Chain of Responsibility Design Pattern
        > The request must be received not guarantee.
        > The performance of the system will be affected, but also in the code debugging is not easy may cause cycle call.
        > It may not be easy to observe the characteristics of operation, due to debug.
        
 */

/*
Let's say we have a customer support system where a customer can submit a support request with different levels of priority: 
low, medium, and high. We want to create a chain of handlers to process these requests based on their priority.

First, we'll create an abstract class called RequestHandler to define the interface for all handlers in the chain:
 */
abstract class RequestHandler {
    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (canHandle(request)) {
            processRequest(request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler found for request: " + request);
        }
    }

    protected abstract boolean canHandle(Request request);

    protected abstract void processRequest(Request request);
}

/*
The handleRequest() method now checks if the current handler can handle the request by calling the canHandle() method.
If it can, it processes the request by calling the processRequest() method. If it can't handle the request, it passes the 
request to the next handler in the chain. If there is no next handler and the request still hasn't been handled, it 
prints an error message.

Next, we'll create three concrete handler classes: LowPriorityHandler, MediumPriorityHandler, and HighPriorityHandler:
 */
class LowPriorityHandler extends RequestHandler {
    public LowPriorityHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Request request) {
        return request.getPriority() == Priority.LOW;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("Handling low priority request: " + request + "\n");
    }
}

class MediumPriorityHandler extends RequestHandler {
    public MediumPriorityHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Request request) {
        return request.getPriority() == Priority.MEDIUM;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("Handling medium priority request: " + request + "\n");
    }
}

class HighPriorityHandler extends RequestHandler {
    public HighPriorityHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Request request) {
        return request.getPriority() == Priority.HIGH;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("Handling high priority request: " + request + "\n");
    }
}

enum Priority {
    LOW, MEDIUM, HIGH
}

/*
Each concrete handler class implements the canHandle() and processRequest() methods to handle requests with a specific 
priority level. The constructor takes a RequestHandler object as a parameter, which represents the next handler in the chain.

Finally, we can create a Request class to represent a support request:
 */

class Request {
    private String description;
    private Priority priority;

    public Request(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Request{" +
                "description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}

/*
The Request class simply stores a description and a priority level for a support request.

The CustomerSupport class creates a chain of handlers with the LowPriorityHandler at the beginning of the chain and the 
HighPriorityHandler at the end of the chain. It sets the handler variable to the LowPriorityHandler, which represents the 
start of the chain.

The processRequest() method takes a Request object as a parameter and calls the handleRequest() method on the handler 
variable. This starts the chain of handlers and each handler in the chain checks if it can handle the request. 
If a handler can handle the request, it processes the request and the chain stops. If a handler can't handle the request, 
it passes the request to the next handler in the chain until the request is handled or there are no more handlers left in the chain.

Now, we can use the Chain of Responsibility pattern to handle support requests based on their priority level:
 */

class CustomerSupport {
    private RequestHandler handler;

    public CustomerSupport() {
        // Create the chain of handlers
        RequestHandler highPriorityHandler = new HighPriorityHandler(null);
        RequestHandler mediumPriorityHandler = new MediumPriorityHandler(highPriorityHandler);
        RequestHandler lowPriorityHandler = new LowPriorityHandler(mediumPriorityHandler);

        handler = lowPriorityHandler;
    }

    public void processRequest(Request request) {
        System.out.println("Processing request: " + request);
        handler.handleRequest(request);
    }
}