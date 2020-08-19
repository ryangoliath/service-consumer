package net.iqbusiness.messaging.queue;

public enum Queue {
	
    ASSESSMENT("IQ_BUSINESS.ASSESSMENT.RYAN.GOLIATH");
    
    private String name;

    private Queue(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

