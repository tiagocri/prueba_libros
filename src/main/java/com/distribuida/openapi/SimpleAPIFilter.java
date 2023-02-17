package com.distribuida.openapi;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.info.License;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;

import java.util.*;

public class SimpleAPIFilter implements OASFilter {

    @Override
    public APIResponse filterAPIResponse(APIResponse apiResponse) {
        if ("Complete".equals(apiResponse.getDescription())) {
            apiResponse.setDescription("Libro no existe");
        }
        return apiResponse;
    }

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {
        openAPI.setInfo(
                OASFactory
                        .createObject(Info.class)
                        .license(OASFactory.createObject(License.class)
                                .url("https://www.eclipse.org/legal/epl-v10.html")));

        openAPI.addServer(
                OASFactory.createServer()
                        .url("http://localhost:{port}")
                        .variables(Collections.singletonMap("port",
                                OASFactory.createServerVariable()
                                        .defaultValue("7001"))));
        var tag = OASFactory.createTag().name("Books");
        List<String> tags = new ArrayList<>();
        tags.add("Books");
        openAPI.setPaths(OASFactory.createPaths()
                .addPathItem("/books",
                        OASFactory.createPathItem()
                                .GET(OASFactory.createOperation()
                                        .tags(tags))));

    }

    @Override
    public Operation filterOperation(Operation operation) {
        if ("books".equals(operation.getOperationId())){
            operation.setDescription("Consultar Libros");
        }
        return OASFilter.super.filterOperation(operation);
    }
}
