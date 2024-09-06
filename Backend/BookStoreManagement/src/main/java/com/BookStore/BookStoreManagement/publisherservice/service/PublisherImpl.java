package com.BookStore.BookStoreManagement.publisherservice.service;
import com.BookStore.BookStoreManagement.publisherservice.dto.PublisherDTO;
import com.BookStore.BookStoreManagement.publisherservice.entity.Publisher;
import com.BookStore.BookStoreManagement.publisherservice.repository.PublisherRepository;
import com.BookStore.BookStoreManagement.publisherservice.util.VariableList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the PublisherService interface.
 * This service provides business logic for managing publishers, including
 * saving, updating, retrieving, and deleting publishers.
 */

@Service
@Transactional

public class PublisherImpl implements PublisherService{
    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * Save a new publisher in the system.
     *
     * @param publisherDTO the publisher data to be saved
     * @return a response code indicating success or duplication
     */

    @Override
    public String savePublisher(PublisherDTO publisherDTO) {
        if (publisherRepository.existsById(publisherDTO.getPublisher_Id())) {
            return VariableList.RESPONSE_DUPLICATED;
        } else {
            publisherRepository.save(modelMapper.map(publisherDTO, Publisher.class));
            return VariableList.RESPONSE_SUCCESS;
        }
    }

    /**
     * Update an existing publisher in the system.
     *
     * @param publisherDTO the updated publisher data
     * @return a response code indicating success or no data found
     */
    @Override
    public String updatePublisher(PublisherDTO publisherDTO) {
        if (publisherRepository.existsById(publisherDTO.getPublisher_Id())) {
            publisherRepository.save(modelMapper.map(publisherDTO, Publisher.class));
            return VariableList.RESPONSE_SUCCESS;
        } else {
            return VariableList.RESPONSE_NO_DATA_FOUND;
        }
    }
    /**
     * Retrieve all publishers from the system.
     *
     * @return a list of PublisherDTOs representing all publishers
     */
    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> publisherList = publisherRepository.findAll();
        return modelMapper.map(publisherList, new TypeToken<ArrayList<PublisherDTO>>(){}.getType());
    }

    /**
     * Search for a specific publisher by their ID.
     *
     * @param publisher_Id the ID of the publisher to search for
     * @return a PublisherDTO representing the found publisher or null if not found
     */
    @Override
    public PublisherDTO searchPublisher(int publisher_Id) {
        if (publisherRepository.existsById(publisher_Id)) {
            Publisher publisher = publisherRepository.findById(publisher_Id).orElse(null);
            return modelMapper.map(publisher, PublisherDTO.class);
        } else {
            return null;
        }
    }

    /**
     * Delete a publisher from the system by their ID.
     *
     * @param publisher_Id the ID of the publisher to be deleted
     * @return a response code indicating success or no data found
     */
    @Override
    public String deletePublisher(int publisher_Id) {
        if (publisherRepository.existsById(publisher_Id)) {
            publisherRepository.deleteById(publisher_Id);
            return VariableList.RESPONSE_SUCCESS;
        } else {
            return VariableList.RESPONSE_NO_DATA_FOUND;
        }
    }

}
