package test.com.sho.hire.hw; 

import com.sho.hire.hw.ReplaceRogersJosh;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.Assert;

/** 
* ReplaceRogersJosh Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 17, 2014</pre> 
* @version 1.0 
*/ 
public class ReplaceRogersJoshTest {

@Before
public void before() throws Exception {

}

@After
public void after() throws Exception {
}

/** 
* 
* Method: addInReverse(String s)
* 
*/ 
@Test
public void testAddInReverseForSBuf() throws Exception {
    ReplaceRogersJosh.ReverseStringBuffer buf = new ReplaceRogersJosh.ReverseStringBuffer(2);
    buf.addInReverse('a');
    buf.addInReverse("b c");
    Assert.assertEquals(buf.toString(),"c ab");
}

/**
 *
 * Method: addInReverse(StringBuffer buff)
 *
 */
@Test
public void testAddInReverseForBBuf() throws Exception {
    ReplaceRogersJosh.ReverseStringBuffer buf = new ReplaceRogersJosh.ReverseStringBuffer(2);
    StringBuffer needlebuff = new StringBuffer(2);
    needlebuff.append("b c");
    buf.addInReverse('a');
    buf.addInReverse(needlebuff);
    Assert.assertEquals(buf.toString(),"c ab");
}
    /**
* 
* Method: addInReverse(char c)
* 
*/ 
@Test
public void testAddInReverseForCBuf() throws Exception {
    ReplaceRogersJosh.ReverseStringBuffer buf = new ReplaceRogersJosh.ReverseStringBuffer(2);
    buf.addInReverse('a');
    buf.addInReverse('b');
    buf.addInReverse(' ');
    buf.addInReverse('c');
    Assert.assertEquals(buf.toString(),"c ab");
} 

/** 
* 
* Method: ecalpeResrever(String haystack, String needle, String replacement) 
* 
*/ 
@Test
public void testEcalpeResrever() throws Exception {
    //default tests
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("ABC", "A", "a"), "aBC");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("AAA AAB BAA", "AA", "a"),"Ba aB aA");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("I Work.", "Work", "Play"),"Play. I");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("Tests are the best!","the best!","just ok."),"ok. just are Tests");
    //testing ends
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl hello world", "ld", "mer bur"),"bur wormer hello blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl hello world","ld","mer"),"wormer hello blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world","hello world", "o m g"),"g m o mergl blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world","hello world","mer bur"),"bur mer mergl blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world","hello world","mer"),"mer mergl blergl");
    //testing beginning
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl hello world","bl","mer bur"),"world hello burergl mer");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl hello world","bl","mer"),"world hello merergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world","blergl mergl","mer bur"),"world hello bur mer");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world", "blergl mergl","mer"),"world hello mer");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world", "blergl mergl","o m g"),"world hello g m o");
    //testing middle
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl hello world","el","mer bur"),"world burlo hmer blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl hello world","el","mer"),"world hmerlo blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world","mergl hello", "o m g"),"world g m o blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world","mergl hello","mer bur"),"world bur mer blergl");
    Assert.assertEquals(ReplaceRogersJosh.ecalpeResrever("blergl mergl hello world","mergl hello","mer"),"world mer blergl");

}

} 
