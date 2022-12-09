package com.bilgeadamboost.springbootcartservice.controller.endpoint;

public class MemberControllerEndpoint {
    public static final String PATH = "/member";
    public static final String ADD_MEMBER = PATH + "/add";
    public static final String GET_MEMBER = PATH + "/get/{id}";
    public static final String UPDATE_MEMBER = PATH + "/update/{id}";
    public static final String DELETE_MEMBER = PATH + "/delete/{id}";
    public static final String GET_MEMBERS = PATH + "/get/all";
}
