package com.assettec.api.internal.utilities.requests.requestbuilders;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GridRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String buildGridRequest(ApiUser apiUser, String gridName, String userFunctionName) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"5000000\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildGridRequest(ApiUser apiUser, String gridName, String userFunctionName, int rows) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"" + rows + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildGridRequest(ApiUser apiUser, String gridName, String userFunctionName, int rows, int position) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"" + rows + "\" CURSOR_POSITION=\"" + position + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildGridRequestWithCursor(ApiUser apiUser, String gridName, String userFunctionName, long position) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"5000000\" CURSOR_POSITION=\"" + position + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildDataSpyGridRequest(ApiUser apiUser, String gridName, String userFunctionName, String dataSpyId) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LOV.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"999999999\" CURSOR_POSITION=\"0\" TAB_NAME=\"\"  RESULT_IN_SAXORDER=\"true\" TERSERESPONSE=\"\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LOV\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <DATASPY DATASPY_ID=\"" + dataSpyId + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildDataSpyGridRequestLimited(ApiUser apiUser, String gridName, String userFunctionName, String dataSpyId, int limit) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"" + limit + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <DATASPY DATASPY_ID=\"" + dataSpyId + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildFilterDataSpyGridRequest(ApiUser apiUser, String gridName, String userFunctionName, String dataSpyId, String filterField, String filterValue) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"5000000\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <DATASPY DATASPY_ID=\"" + dataSpyId + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <MULTIADDON_FILTERS xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\">\n" +
                "                    <MADDON_FILTER ALIAS_NAME=\"" + filterField + "\" OPERATOR=\"CONTAINS\" VALUE=\"" + filterValue + "\" />\n" +
                "                </MULTIADDON_FILTERS>" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildFilterGridRequest(ApiUser apiUser, String gridName, String userFunctionName, String filterField, String filterValue, String operator) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"5000000\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <MULTIADDON_FILTERS xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\">\n" +
                "                    <MADDON_FILTER ALIAS_NAME=\"" + filterField + "\" OPERATOR=\"" + operator + "\" VALUE=\"" + filterValue + "\" />\n" +
                "                </MULTIADDON_FILTERS>\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String buildGridRequestWithCursorAndFilter(ApiUser apiUser, String gridName, String userFunctionName, long position, String filterField, String filterValue, String operator) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0118_GetGridHeaderData_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0118_GetGridHeaderData_001\">\n" +
                "            <FUNCTION_REQUEST_INFO REQUEST_TYPE=\"LIST.HEAD_DATA.STORED\">\n" +
                "                <GRID GRID_NAME=\"" + gridName + "\" USER_FUNCTION_NAME=\"" + userFunctionName + "\" NUMBER_OF_ROWS_FIRST_RETURNED=\"5000000\" CURSOR_POSITION=\"" + position + "\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <GRID_TYPE TYPE=\"LIST\" xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\" />\n" +
                "                <MULTIADDON_FILTERS xmlns=\"http://schemas.datastream.net/MP_functions/GridRequest\">\n" +
                "                    <MADDON_FILTER ALIAS_NAME=\"" + filterField + "\" OPERATOR=\"" + operator + "\" VALUE=\"" + filterValue + "\" />\n" +
                "                </MULTIADDON_FILTERS>\n" +
                "            </FUNCTION_REQUEST_INFO>\n" +
                "        </MP0118_GetGridHeaderData_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

}
