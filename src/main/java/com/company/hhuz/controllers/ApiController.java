package com.company.hhuz.controllers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiController<S> {
    protected final S service;
    protected final String API = "/api";
    protected final String V1 = "/v1";
}
