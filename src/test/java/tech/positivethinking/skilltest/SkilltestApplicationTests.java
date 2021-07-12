package tech.positivethinking.skilltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import tech.positivethinking.skilltest.service.PartitionImpl;
import tech.positivethinking.skilltest.utils.PartitionUtils;

@RunWith(MockitoJUnitRunner.class)
public class SkilltestApplicationTests {
	
	private PartitionImpl impl = new PartitionImpl();
	
	@Test
	public void checkExceptions() {
		Exception e = assertThrows(Exception.class, () -> {impl.partition(null, null);});
		assertTrue(PartitionUtils.LIST_IS_NULL.equals(e.getMessage()));
		e = assertThrows(Exception.class, () -> {impl.partition(Arrays.asList(1,"kk",null,"EE",new Date()), null);});
		assertTrue(PartitionUtils.SIZE_IS_NULL.equals(e.getMessage()));
		e = assertThrows(Exception.class, () -> {impl.partition(Arrays.asList(1,"kk",null,"EE",new Date()), 66);});
		assertTrue(PartitionUtils.PARTITION_SIZE_ERROR.equals(e.getMessage()));
		e = assertThrows(Exception.class, () -> {impl.partition(Arrays.asList(1,"kk",null,"EE",new Date()), -1);});
		assertTrue(PartitionUtils.PARTITION_SIZE_NEGATIVE.equals(e.getMessage()));
	}
	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Test
	public void nominalCase() throws Exception {
		List l =  new ArrayList<Object>(Arrays.asList(1,"kk",null,"EE",new Date()));
		List partition1 =  new ArrayList<Object>(Arrays.asList(1,"kk",null));
		List partition2 =  new ArrayList<Object>(Arrays.asList("EE",new Date()));
		List<List<Object>> res = impl.partition(l, 3);
		assertEquals(2, res.size());
		assertEquals(partition1, res.get(0));
		assertEquals(partition2, res.get(1));
	}
	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Test
	public void nullCases() throws Exception {
		List l =  new ArrayList<Object>(Arrays.asList(null, null, null));
		List<List<Object>> res = impl.partition(l, Integer.valueOf(1));
		assertEquals(3, res.size());
	}

}
