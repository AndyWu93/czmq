/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################
*/
package org.zeromq.czmq;

public class Zloop implements AutoCloseable{
    static {
        try {
            System.loadLibrary ("czmqjni");
        }
        catch (Exception e) {
            System.exit (-1);
        }
    }
    public long self;
    /*
    Create a new zloop reactor
    */
    native static long __new ();
    public Zloop () {
        /*  TODO: if __new fails, self is null...            */
        self = __new ();
    }
    public Zloop (long pointer) {
        self = pointer;
    }
    /*
    Destroy a reactor
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Cancel a socket reader from the reactor. If multiple readers exist for
    same socket, cancels ALL of them.                                     
    */
    native static void __readerEnd (long self, long sock);
    public void readerEnd (Zsock sock) {
        __readerEnd (self, sock.self);
    }
    /*
    Configure a registered reader to ignore errors. If you do not set this,
    then readers that have errors are removed from the reactor silently.   
    */
    native static void __readerSetTolerant (long self, long sock);
    public void readerSetTolerant (Zsock sock) {
        __readerSetTolerant (self, sock.self);
    }
    /*
    Cancel a specific timer identified by a specific timer_id (as returned by
    zloop_timer).                                                            
    */
    native static int __timerEnd (long self, int timerId);
    public int timerEnd (int timerId) {
        return __timerEnd (self, timerId);
    }
    /*
    Reset a ticket timer, which moves it to the end of the ticket list and
    resets its execution time. This is a very fast operation.             
    */
    native static void __ticketReset (long self, long handle);
    public void ticketReset (long handle) {
        __ticketReset (self, handle);
    }
    /*
    Delete a ticket timer. We do not actually delete the ticket here, as    
    other code may still refer to the ticket. We mark as deleted, and remove
    later and safely.                                                       
    */
    native static void __ticketDelete (long self, long handle);
    public void ticketDelete (long handle) {
        __ticketDelete (self, handle);
    }
    /*
    Set the ticket delay, which applies to all tickets. If you lower the   
    delay and there are already tickets created, the results are undefined.
    */
    native static void __setTicketDelay (long self, long ticketDelay);
    public void setTicketDelay (long ticketDelay) {
        __setTicketDelay (self, ticketDelay);
    }
    /*
    Set hard limit on number of timers allowed. Setting more than a small  
    number of timers (10-100) can have a dramatic impact on the performance
    of the reactor. For high-volume cases, use ticket timers. If the hard  
    limit is reached, the reactor stops creating new timers and logs an    
    error.                                                                 
    */
    native static void __setMaxTimers (long self, long maxTimers);
    public void setMaxTimers (long maxTimers) {
        __setMaxTimers (self, maxTimers);
    }
    /*
    Set verbose tracing of reactor on/off
    */
    native static void __setVerbose (long self, boolean verbose);
    public void setVerbose (boolean verbose) {
        __setVerbose (self, verbose);
    }
    /*
    Start the reactor. Takes control of the thread and returns when the 0MQ  
    context is terminated or the process is interrupted, or any event handler
    returns -1. Event handlers may register new sockets and timers, and      
    cancel sockets. Returns 0 if interrupted, -1 if cancelled by a handler.  
    */
    native static int __start (long self);
    public int start () {
        return __start (self);
    }
    /*
    Ignore zsys_interrupted flag in this loop. By default, a zloop_start will 
    exit as soon as it detects zsys_interrupted is set to something other than
    zero. Calling zloop_ignore_interrupts will supress this behavior.         
    */
    native static void __ignoreInterrupts (long self);
    public void ignoreInterrupts () {
        __ignoreInterrupts (self);
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public void test (boolean verbose) {
        __test (verbose);
    }
}
