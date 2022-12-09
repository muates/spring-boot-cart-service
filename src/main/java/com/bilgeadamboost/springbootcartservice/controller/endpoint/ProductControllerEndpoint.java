package com.bilgeadamboost.springbootcartservice.controller.endpoint;

public class ProductControllerEndpoint {
    public static final String PATH = "/product";
    public static final String ADD_PRODUCT = PATH + "/add";
    public static final String GET_PRODUCT = PATH + "/get/{id}";
    public static final String DELETE_PRODUCT = PATH + "/delete/{id}";
    public static final String UPDATE_PRODUCT = PATH + "/update/{id}";
    public static final String GET_PRODUCTS = PATH + "/get/all";
}
