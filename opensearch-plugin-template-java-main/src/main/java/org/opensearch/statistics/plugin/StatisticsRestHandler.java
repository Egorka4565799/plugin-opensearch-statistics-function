package org.opensearch.statistics.plugin;

import org.opensearch.client.node.NodeClient;
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.BytesRestResponse;
import org.opensearch.rest.RestRequest;
import org.opensearch.rest.RestResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.opensearch.rest.RestRequest.Method.POST;

public class StatisticsRestHandler extends BaseRestHandler {

    @Override
    public String getName() {
        return "statistics_functions_handler";
    }

    @Override
    public List<Route> routes() {
        return Collections.singletonList(new Route(POST, "/_statistics/{functionName}"));
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        String functionName = request.param("functionName");

        InputStream jsonDataStream = request.content().streamInput();

        ExecuteService service = new ExecuteService();
        // Выполнение статистической функции
        String result = service.executeFunction(functionName, jsonDataStream);

        return channel -> {
            RestResponse response = new BytesRestResponse(RestStatus.OK, result);
            channel.sendResponse(response);
        };
    }


}
