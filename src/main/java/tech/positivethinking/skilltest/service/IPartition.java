package tech.positivethinking.skilltest.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IPartition {
	List<List<Object>> partition (List<Object> liste, Integer taille) throws Exception;
}
