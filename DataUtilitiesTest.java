package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	@Test
	public void calculateColumnTotalForTwoValues() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals("The column total value should be 10.", result, 10.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test (expected = NullPointerException.class)
	public void calculateNullColumn() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            
	            one(values).getValue(0, -1);
	            will(throwException(new IndexOutOfBoundsException()));
	        }
	    });
	    
	    Integer nullVal = null;
	 
	    DataUtilities.calculateColumnTotal(values, nullVal);
	    // verify
	    // tear-down: NONE in this test method
	}
	
	
	
	@Test
	public void calculateRowForTwoValues() {
	    // setup
	    Mockery mockingContext2 = new Mockery();
	    final Values2D values2 = mockingContext2.mock(Values2D.class);
	    mockingContext2.checking(new Expectations() {
	        {
	            one(values2).getRowCount();
	            will(returnValue(2));
	            one(values2).getColumnCount();
	            will(returnValue(2));
	            one(values2).getValue(0, 0);
	            will(returnValue(5.5));
	            one(values2).getValue(0, 1);
	            will(returnValue(4.5));
	        }
	    });
	    
	    double result2 = DataUtilities.calculateRowTotal(values2, 0);
	    // verify
	    assertEquals("The row total value should be 10.", result2, 10, .000000001d);
	    //assertNull("The column total value should be NULL.", result2);
	    // tear-down: NONE in this test method
	}
	
	@Test (expected = NullPointerException.class)
	public void calculateNullRowTotal() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            
	            one(values).getValue(-1, 0);
	            will(throwException(new IndexOutOfBoundsException()));

	        }
	    });
	    
	    Integer nullVal = null;
	 
	    DataUtilities.calculateColumnTotal(values, nullVal);
	    // verify
	    // tear-down: NONE in this test method
	}
	
	
	@Test 
	public void createNumberArrayTest() {
	    // setup
		
		double[] test = {1, 2, 3};
		Number[] answer = {1.0, 2.0, 3.0};
		
		assertArrayEquals("Arrays should be equal.", answer, DataUtilities.createNumberArray(test));
		
	}
	
	@Test 
	public void createNumberArrayWithDoubles() {
	    // setup
		
		double[] test = {1.45, 2.84, 3.35};
		Number[] answer = {1.45, 2.84, 3.35};
		
		assertArrayEquals("Arrays should be equal.", answer, DataUtilities.createNumberArray(test));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArrayWithNull() {
	    // setup
		
		double[] test = null;
		
		assertNull("This array should be null.", DataUtilities.createNumberArray(test));
	}
	
	@Test 
	public void createNumberArray2DTest() {
	    // setup
		
		double[][] test = {{1, 1}, {2, 2}, {3, 3}};
		Number[][] answer = {{1.0, 1.0}, {2.0, 2.0}, {3.0, 3.0}};
		
		assertArrayEquals("Arrays should be equal.", answer, DataUtilities.createNumberArray2D(test));
		
	}
	
	@Test 
	public void createEmptyNumberArray2D() {
	    // setup
		
		double[][] test = {};
		Number[][] answer = {};
		
		assertArrayEquals("Array should be empty.", answer, DataUtilities.createNumberArray2D(test));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createNullNumberArray2D() {
	    // setup
		
		double[][] test = null;
		Number[][] answer = {};
		
		assertNull("Array should be NULL.", DataUtilities.createNumberArray2D(test));
	}
	
	
	@Test
	public void getCumulativePercentagesTest() {
		Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	 allowing(values).getItemCount();
	                will(returnValue(1));
	                allowing(values).getValue(0);
	                will(returnValue(2));
	                allowing(values).getKey(0);
	                will(returnValue(1));
	            }
	        });

	        KeyedValues result = DataUtilities.getCumulativePercentages(values);
	        assertEquals("Results should be equal to 1.", 1.0, result.getValue(0));
	}
	
//	@Test
//	public void getCumulativePercentagesTest2() {
//		Mockery mockingContext = new Mockery();
//	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
//	    mockingContext.checking(new Expectations() {
//	        {
//	        	 allowing(values).getItemCount();
//	                will(returnValue(1));
//	                allowing(values).getValue(0);
//	                will(returnValue(2));
//	                allowing(values).getKey(0);
//	                will(returnValue(1));
//	            }
//	        });
//
//	        KeyedValues result = DataUtilities.getCumulativePercentages(values);
//	        assertEquals("Results should be equal to 1.", 1.0, result.getValue(0));
//	}
	
	@Test
	public void getCumulativePercentagesTestWithLotsOfValues() {
		Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getItemCount();
	            will(returnValue(4));
	            allowing(values).getValue(0);
	            will(returnValue(2));
	            allowing(values).getValue(1);
	            will(returnValue(2));
	            allowing(values).getValue(2);
	            will(returnValue(2));
	            allowing(values).getValue(3);
	            will(returnValue(2));
	            allowing(values).getKey(0);
	            will(returnValue(0));
	            allowing(values).getKey(1);
	            will(returnValue(1));
	            allowing(values).getKey(2);
	            will(returnValue(2));
	            allowing(values).getKey(3);
	            will(returnValue(3));
	        }
	    });
	
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    assertEquals(0.25, result.getValue(0));
	    assertEquals(0.5, result.getValue(1));
//	    assertEquals(0.75, result.getValue(2));
//	    assertEquals(1.0, result.getValue(3));
	}

	@Test
	public void getCumulativePercentagesTestWithTwoValues() {
		Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getItemCount();
	            will(returnValue(2));
	            allowing(values).getValue(0);
	            will(returnValue(2));
	            allowing(values).getValue(1);
	            will(returnValue(2));
	            allowing(values).getKey(0);
	            will(returnValue(0));
	            allowing(values).getKey(1);
	            will(returnValue(1));

	        }
	    });
	
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	    assertEquals(0.5, result.getValue(0));
	    assertEquals(1.0, result.getValue(1));

	}
	
	@Test(expected = IllegalStateException.class)
	public void getCumulativePercentagesTestNullItems() {
		Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(values).getItemCount();
	            will(returnValue(null));

	        }
	    });
	
	    KeyedValues result = DataUtilities.getCumulativePercentages(values);
	}
	
	@Test
	public void equalsTest() {
		double[][] a = {{1, 1}, {2, 2}, {3, 3}};
		double[][] b = {{1, 1}, {2, 2}, {3, 3}};

		assertTrue("Arrays should be equal.", DataUtilities.equal(a,b));
	}
	
	@Test
	public void equalsTestNotEqual() {
		double[][] a = {{1, 1}, {2, 2}, {3, 3}};
		double[][] b = {{1, 1}, {2, 2}, {3, 4}};

		assertFalse("Arrays should not be equal.", DataUtilities.equal(a,b));
	}
	
	@Test
	public void equalsTestEmptyArrays() {
		double[][] a = {};
		double[][] b = {};

		assertTrue("Arrays should be equal.", DataUtilities.equal(a,b));
	}
	
	@Test
	public void equalsTestNullArrays() {
		double[][] a = null;
		double[][] b = null;

		assertTrue("Arrays should be equal.", DataUtilities.equal(a,b));
	}
	
	@Test
	public void equalsTestDifferentLengthsAShorter() {
		double[][] a = {{1, 2}};
		double[][] b = {{1, 2}, {3, 4}};

		assertFalse("Arrays should be not equal.", DataUtilities.equal(a,b));
	}
	
	@Test
	public void equalsTestDifferentLengthsALonger() {
		double[][] a = {{1, 2}, {3, 4}};
		double[][] b = {{1, 2}};

		assertFalse("Arrays should be not equal.", DataUtilities.equal(a,b));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	// Coverage tests
	@Test
	public void calculateColumnTotalCoverageTest() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    int col = 0;
	    
	    double result = DataUtilities.calculateColumnTotal(values, col);
	    
	    assertEquals("Result should equal 10.0", 10.0, result, .000000001d);
	        
	}

	@Test
	public void calculateColumnTotalCoverageTest2() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    int col = 0;
	    
	    double result = DataUtilities.calculateColumnTotal(values, col);
	    assertEquals("Result should equal 2.5", 2.5, result, .000000001d);
	        
	}
	
	@Test
	public void equalsCoverageTestA() {
	    // setup
		double[][] a = null;
		double[][] b = {{1,2}};
			    
	    boolean result = DataUtilities.equal(a, b);
	    assertFalse("Should return false.", result);
	        
	}
	
	@Test
	public void equalsCoverageTestB() {
	    // setup
		double[][] a = {{1,2}};
		double[][] b = null;
			    
	    boolean result = DataUtilities.equal(a, b);
	    assertFalse("Should return false.", result);
	}
	
	@Test
	public void equalsCoverageTestEqualLength() {
	    // setup
		double[][] b = {{2,1}, {1,2}};
		double[][] a = {{1,2}};
			    
	    boolean result = DataUtilities.equal(a, b);
	    assertFalse("Should return false.", result);
	}
	
	@Test
	public void cloneCoverageTest() {
	    // setup
		double[][] a = {{1,2}};
			    
	    double result[][] = DataUtilities.clone(a);
	   assertArrayEquals("Result should equal {{1,2}}.", a, result);
	        
	}
	
	@Test
	public void cloneCoverageTestElse() {
	    // setup
		double[][] a = {null};
			    
	    double result[][] = DataUtilities.clone(a);
	    assertArrayEquals("Result should {null}.", a, result);
	        
	}
	
	@Test
	public void calculateColumnTotalValidRowsCoverageTest() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    int col = 0;
	    int[] validRows= {0, 1};	    
	    double result = DataUtilities.calculateColumnTotal(values, col, validRows);
	    
	    assertEquals("Result should equal 2.5", 2.5, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalValidRowsCoverageTest2() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    int col = 0;
	    int[] validRows= {0, 15};	    
	    double result = DataUtilities.calculateColumnTotal(values, col, validRows);
	    
	    assertEquals("Result should be 0.0", 0.0, result, .000000001d);
	    //assertNull("Result should be null.", result);
	}
	
	/*@Test
	public void calculateRowTotalElseCoverageTest() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(0));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    int col = 0;
	    int[] validRows= {0, 15};	    
	    double result = DataUtilities.calculateRowTotal(values, col);
	    assertEquals("Result should be 2.5.", 2.5, result, .000000001d);
	    //assertNull("Result should be null.", result);

	}*/
	
	@Test
	public void calculateRowTotalValidRowsCoverageTest() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(0));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    int col = 1;
	    int[] validCols= {0, 15};	    
	    double result = DataUtilities.calculateRowTotal(values, col, validCols);
	    assertEquals("Result should be 2.5.", 2.5, result, .000000001d);

	}
	
	@Test
	public void calculateRowTotalValidRowsElseCoverageTest() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(4.0));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    int col = 0;
	    int[] validCols= {0, 15};	    
	    double result = DataUtilities.calculateRowTotal(values, col, validCols);
	    assertEquals("Result should be 4.0.", 4.0, result, .000000001d);

	}
}