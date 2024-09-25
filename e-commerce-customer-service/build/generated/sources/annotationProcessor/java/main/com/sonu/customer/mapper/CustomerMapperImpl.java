package com.sonu.customer.mapper;

import com.sonu.customer.beans.entity.Address;
import com.sonu.customer.beans.entity.Customer;
import com.sonu.customer.beans.request.AddressRequest;
import com.sonu.customer.beans.request.CustomerRequest;
import com.sonu.customer.beans.response.AddressResponse;
import com.sonu.customer.beans.response.CustomerResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T17:14:47+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.1.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer prepareRequest(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setAddresses( addressRequestListToAddressList( customerRequest.getAddresses() ) );
        customer.setCustomerId( customerRequest.getCustomerId() );
        customer.setCustomerName( customerRequest.getCustomerName() );
        customer.setCustomerDOB( customerRequest.getCustomerDOB() );
        customer.setPhoneNumber( customerRequest.getPhoneNumber() );
        customer.setEmail( customerRequest.getEmail() );
        customer.setPassword( customerRequest.getPassword() );

        return customer;
    }

    @Override
    public CustomerResponse prepareResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setAddresses( addressListToAddressResponseList( customer.getAddresses() ) );
        customerResponse.setCustomerId( customer.getCustomerId() );
        customerResponse.setCustomerName( customer.getCustomerName() );
        customerResponse.setCustomerDOB( customer.getCustomerDOB() );
        customerResponse.setPhoneNumber( customer.getPhoneNumber() );
        customerResponse.setEmail( customer.getEmail() );
        customerResponse.setPassword( customer.getPassword() );

        return customerResponse;
    }

    protected Address addressRequestToAddress(AddressRequest addressRequest) {
        if ( addressRequest == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressId( addressRequest.getAddressId() );
        address.setAddressType( addressRequest.getAddressType() );
        address.setCustomerId( addressRequest.getCustomerId() );
        address.setFlatNumber( addressRequest.getFlatNumber() );
        address.setPlotNumber( addressRequest.getPlotNumber() );
        address.setBuildingName( addressRequest.getBuildingName() );
        address.setRoadNumber( addressRequest.getRoadNumber() );
        address.setStreet( addressRequest.getStreet() );
        address.setCity( addressRequest.getCity() );
        address.setCountry( addressRequest.getCountry() );
        address.setPinCode( addressRequest.getPinCode() );

        return address;
    }

    protected List<Address> addressRequestListToAddressList(List<AddressRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressRequest addressRequest : list ) {
            list1.add( addressRequestToAddress( addressRequest ) );
        }

        return list1;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setAddressId( address.getAddressId() );
        addressResponse.setAddressType( address.getAddressType() );
        addressResponse.setFlatNumber( address.getFlatNumber() );
        addressResponse.setPlotNumber( address.getPlotNumber() );
        addressResponse.setBuildingName( address.getBuildingName() );
        addressResponse.setRoadNumber( address.getRoadNumber() );
        addressResponse.setStreet( address.getStreet() );
        addressResponse.setCity( address.getCity() );
        addressResponse.setCountry( address.getCountry() );
        if ( address.getPinCode() != null ) {
            addressResponse.setPinCode( String.valueOf( address.getPinCode() ) );
        }
        addressResponse.setCustomerId( address.getCustomerId() );

        return addressResponse;
    }

    protected List<AddressResponse> addressListToAddressResponseList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressResponse> list1 = new ArrayList<AddressResponse>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressResponse( address ) );
        }

        return list1;
    }
}
