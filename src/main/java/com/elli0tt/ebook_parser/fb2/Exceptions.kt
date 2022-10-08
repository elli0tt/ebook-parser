package com.elli0tt.ebook_parser.fb2

class RequiredParamNotProvidedException(paramName: String) :
    RuntimeException("Param $paramName must be provided in builder")