package ss.week2;

public class Rectangle {
	
    private int length;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     */
    /*@ requires theLength >= 0;
        requires theWidth >= 0;
     */
    public Rectangle(int theLength, int theWidth) {
    	assert theLength >= 0;
    	assert theWidth >= 0;
    	
    	this.length = theLength;
    	this.width = theWidth;
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ ensures \result >= 0;
    /*@ pure */public int length() {
    	assert this.length >= 0;
    	
    	return this.length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result >= 0;
    /*@ pure */public int width() {
    	assert this.width >= 0;
    	
    	return this.width;
    }

    /**
     * The area of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@ ensures \result == width() * length();
    /*@ pure */public int area() {
    	assert this.length >= 0;
    	assert this.width >= 0;
    	
    	return this.length * this.width;
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@ ensures \result == 2*width() + 2*length();
    /*@ pure */public int perimeter() {
    	assert this.length >= 0;
    	assert this.width >= 0;
    	
    	return this.length + this.width + this.length + this.width;
    }
}
