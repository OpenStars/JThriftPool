package jcommon.transport.client;
import java.util.*;
import java.lang.*;

class Thing {
	 
    public static int number_of_things = 0;
    public String what;
 
    public Thing (String what) {
            this.what = what;
            number_of_things++;
            }
 
    protected void finalize ()  {
            number_of_things--;
            System.out.println("destroy thing " + what );
            }
    }
 
