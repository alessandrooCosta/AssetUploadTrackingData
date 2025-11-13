package com.assettec.api.internal.core.user.info.fields;

import com.assettec.api.internal.core.entities.basic.setter.CountSetter;
import com.assettec.api.internal.core.entities.basic.setter.DateSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class UserDefinedFieldsSetter {

    private CountSetter countSetter;
    private DateSetter dateSetter;

    public UserDefinedFields setUserDefinedFields(NodeList childNodes) {
        UserDefinedFields userDefinedFields = new UserDefinedFields();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node userDefinedFieldNode = childNodes.item(i);
            String userDefinedFieldName = userDefinedFieldNode.getNodeName();

            if (userDefinedFieldName.equals("UDFCHAR01")) userDefinedFields.setUdfChar01(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR02")) userDefinedFields.setUdfChar02(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR03")) userDefinedFields.setUdfChar03(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR04")) userDefinedFields.setUdfChar04(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR05")) userDefinedFields.setUdfChar05(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR06")) userDefinedFields.setUdfChar06(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR07")) userDefinedFields.setUdfChar07(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR08")) userDefinedFields.setUdfChar08(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR09")) userDefinedFields.setUdfChar09(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR10")) userDefinedFields.setUdfChar10(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR11")) userDefinedFields.setUdfChar11(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR12")) userDefinedFields.setUdfChar12(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHAR13")) {
                userDefinedFields.setUdfChar13(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR14")) {
                userDefinedFields.setUdfChar14(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR15")) {
                userDefinedFields.setUdfChar15(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR16")) {
                userDefinedFields.setUdfChar16(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR17")) {
                userDefinedFields.setUdfChar17(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR18")) {
                userDefinedFields.setUdfChar18(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR19")) {
                userDefinedFields.setUdfChar19(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR20")) {
                userDefinedFields.setUdfChar20(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR21")) {
                userDefinedFields.setUdfChar21(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR22")) {
                userDefinedFields.setUdfChar22(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR23")) {
                userDefinedFields.setUdfChar23(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR24")) {
                userDefinedFields.setUdfChar24(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR25")) {
                userDefinedFields.setUdfChar25(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR26")) {
                userDefinedFields.setUdfChar26(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR27")) {
                userDefinedFields.setUdfChar27(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR28")) {
                userDefinedFields.setUdfChar28(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR29")) {
                userDefinedFields.setUdfChar29(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR30")) {
                userDefinedFields.setUdfChar30(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR31")) {
                userDefinedFields.setUdfChar31(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR32")) {
                userDefinedFields.setUdfChar32(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR33")) {
                userDefinedFields.setUdfChar33(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR34")) {
                userDefinedFields.setUdfChar34(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR35")) {
                userDefinedFields.setUdfChar35(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR36")) {
                userDefinedFields.setUdfChar36(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR37")) {
                userDefinedFields.setUdfChar37(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR38")) {
                userDefinedFields.setUdfChar38(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR39")) {
                userDefinedFields.setUdfChar39(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR40")) {
                userDefinedFields.setUdfChar40(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR41")) {
                userDefinedFields.setUdfChar41(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR42")) {
                userDefinedFields.setUdfChar42(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR43")) {
                userDefinedFields.setUdfChar43(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR44")) {
                userDefinedFields.setUdfChar44(userDefinedFieldNode.getTextContent());
            }
            if (userDefinedFieldName.equals("UDFCHAR45")) {
                userDefinedFields.setUdfChar45(userDefinedFieldNode.getTextContent());
            }

            if (userDefinedFieldName.equals("UDFNUM01")) userDefinedFields.setUdfNum1(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM02")) userDefinedFields.setUdfNum2(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM03")) userDefinedFields.setUdfNum3(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM04")) userDefinedFields.setUdfNum4(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM05")) userDefinedFields.setUdfNum5(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM06")) userDefinedFields.setUdfNum6(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM07")) userDefinedFields.setUdfNum7(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM08")) userDefinedFields.setUdfNum8(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM09")) userDefinedFields.setUdfNum9(countSetter.setCount(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFNUM10")) userDefinedFields.setUdfNum10(countSetter.setCount(userDefinedFieldNode.getChildNodes()));

            if (userDefinedFieldName.equals("UDFDATE01")) userDefinedFields.setUdfDate1(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE02")) userDefinedFields.setUdfDate2(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE03")) userDefinedFields.setUdfDate3(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE04")) userDefinedFields.setUdfDate4(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE05")) userDefinedFields.setUdfDate5(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE06")) userDefinedFields.setUdfDate6(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE07")) userDefinedFields.setUdfDate7(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE08")) userDefinedFields.setUdfDate8(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE09")) userDefinedFields.setUdfDate9(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));
            if (userDefinedFieldName.equals("UDFDATE10")) userDefinedFields.setUdfDate10(dateSetter.setDate(userDefinedFieldNode.getChildNodes()));

            if (userDefinedFieldName.equals("UDFCHKBOX01")) userDefinedFields.setUdfChkBox01(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX02")) userDefinedFields.setUdfChkBox02(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX03")) userDefinedFields.setUdfChkBox03(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX04")) userDefinedFields.setUdfChkBox04(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX05")) userDefinedFields.setUdfChkBox05(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX06")) userDefinedFields.setUdfChkBox06(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX07")) userDefinedFields.setUdfChkBox07(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX08")) userDefinedFields.setUdfChkBox08(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX09")) userDefinedFields.setUdfChkBox09(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFCHKBOX10")) userDefinedFields.setUdfChkBox10(userDefinedFieldNode.getTextContent());

            if (userDefinedFieldName.equals("UDFNOTE01")) userDefinedFields.setUdfNote01(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE02")) userDefinedFields.setUdfNote02(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE03")) userDefinedFields.setUdfNote03(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE04")) userDefinedFields.setUdfNote04(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE05")) userDefinedFields.setUdfNote05(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE06")) userDefinedFields.setUdfNote06(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE07")) userDefinedFields.setUdfNote07(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE08")) userDefinedFields.setUdfNote08(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE09")) userDefinedFields.setUdfNote09(userDefinedFieldNode.getTextContent());
            if (userDefinedFieldName.equals("UDFNOTE10")) userDefinedFields.setUdfNote10(userDefinedFieldNode.getTextContent());

        }
        return userDefinedFields;
    }
}