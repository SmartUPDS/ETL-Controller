package com.smartupds.etlcontroller.etl.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/** POJO for modeling a triplestore connection
 * 
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Data @AllArgsConstructor
public class TripleStoreConnection {
    private String connectionURL;
    private String username;
    private String password;
}
