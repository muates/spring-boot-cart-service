package com.bilgeadamboost.springbootcartservice.controller.endpoint;

public class AddressControllerEndpoint {
    public static final String PATH = "/address";
    public static final String ADD_ADDRESS = PATH + "/add";
    public static final String GET_ADDRESS = PATH + "/get/{id}";
    public static final String UPDATE_ADDRESS = PATH + "/update/{id}";
    public static final String DELETE_ADDRESS = PATH + "/delete/{id}";
    public static final String GET_ALL_ADDRESS_BY_MEMBER_ID = PATH + "/get/member/{id}";
    public static final String GET_ADDRESS_LENGTH_BY_MEMBER_ID = "get/length/member/{id}";
}
