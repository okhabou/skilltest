package tech.positivethinking.skilltest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import tech.positivethinking.skilltest.utils.PartitionUtils;

public class PartitionImpl implements IPartition{
	public List<List<Object>> partition(List<Object> liste, Integer taille) throws Exception {
		if(Objects.isNull(liste)) {
			throw new Exception(PartitionUtils.LIST_IS_NULL);
		}
		else if(Objects.isNull(taille)) {
			throw new Exception(PartitionUtils.SIZE_IS_NULL);
		}
		else if( liste.isEmpty()) {
			throw new Exception(PartitionUtils.LIST_EMPTY);
		}
		else if(taille > liste.size()) {
			throw new Exception(PartitionUtils.PARTITION_SIZE_ERROR);
		}
		else if(taille < 0) {
			throw new Exception(PartitionUtils.PARTITION_SIZE_NEGATIVE);
		}
	    List<List<Object>> result = new ArrayList<List<Object>>();

	    for (int i=0; i<liste.size(); i += taille) {
	    	result.add(liste.subList(i, Math.min(i + taille, liste.size())));
	    }
		return result;
	}
}
