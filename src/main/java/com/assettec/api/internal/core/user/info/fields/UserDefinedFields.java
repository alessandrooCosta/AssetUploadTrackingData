package com.assettec.api.internal.core.user.info.fields;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDefinedFields {

    private String udfChar01;
    private String udfChar02;
    private String udfChar03;
    private String udfChar04;
    private String udfChar05;
    private String udfChar06;
    private String udfChar07;
    private String udfChar08;
    private String udfChar09;
    private String udfChar10;
    private String udfChar11;
    private String udfChar12;
    private String udfChar13;
    private String udfChar14;
    private String udfChar15;
    private String udfChar16;
    private String udfChar17;
    private String udfChar18;
    private String udfChar19;
    private String udfChar20;
    private String udfChar21;
    private String udfChar22;
    private String udfChar23;
    private String udfChar24;
    private String udfChar25;
    private String udfChar26;
    private String udfChar27;
    private String udfChar28;
    private String udfChar29;
    private String udfChar30;
    private String udfChar31;
    private String udfChar32;
    private String udfChar33;
    private String udfChar34;
    private String udfChar35;
    private String udfChar36;
    private String udfChar37;
    private String udfChar38;
    private String udfChar39;
    private String udfChar40;
    private String udfChar41;
    private String udfChar42;
    private String udfChar43;
    private String udfChar44;
    private String udfChar45;

    private InforEamCount udfNum1;
    private InforEamCount udfNum2;
    private InforEamCount udfNum3;
    private InforEamCount udfNum4;
    private InforEamCount udfNum5;
    private InforEamCount udfNum6;
    private InforEamCount udfNum7;
    private InforEamCount udfNum8;
    private InforEamCount udfNum9;
    private InforEamCount udfNum10;

    private InforEamDate udfDate1;
    private InforEamDate udfDate2;
    private InforEamDate udfDate3;
    private InforEamDate udfDate4;
    private InforEamDate udfDate5;
    private InforEamDate udfDate6;
    private InforEamDate udfDate7;
    private InforEamDate udfDate8;
    private InforEamDate udfDate9;
    private InforEamDate udfDate10;

    private String udfChkBox01;
    private String udfChkBox02;
    private String udfChkBox03;
    private String udfChkBox04;
    private String udfChkBox05;
    private String udfChkBox06;
    private String udfChkBox07;
    private String udfChkBox08;
    private String udfChkBox09;
    private String udfChkBox10;

    private String udfNote01;
    private String udfNote02;
    private String udfNote03;
    private String udfNote04;
    private String udfNote05;
    private String udfNote06;
    private String udfNote07;
    private String udfNote08;
    private String udfNote09;
    private String udfNote10;

    public String buildRequest(String upper, String lower) {

        String udfNum01 = getUdfNum1() == null ? "" : getUdfNum1().buildRequest("<UDFNUM01 qualifier=\"ACTDUR\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM01>");
        String udfNum02 = getUdfNum2() == null ? "" : getUdfNum2().buildRequest("<UDFNUM02 qualifier=\"ACTDUR\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM02>");
        String udfNum03 = getUdfNum3() == null ? "" : getUdfNum3().buildRequest("<UDFNUM03 qualifier=\"ACTDUR\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM03>");
        String udfNum04 = getUdfNum4() == null ? "" : getUdfNum4().buildRequest("<UDFNUM04 qualifier=\"ACTDUR\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM04>");
        String udfNum05 = getUdfNum5() == null ? "" : getUdfNum5().buildRequest("<UDFNUM05 qualifier=\"ACTDUR\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM05>");
        String udfNum06 = getUdfNum6() == null ? "" : getUdfNum6().buildRequest("<UDFNUM06 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM06>");
        String udfNum07 = getUdfNum7() == null ? "" : getUdfNum7().buildRequest("<UDFNUM07 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM07>");
        String udfNum08 = getUdfNum8() == null ? "" : getUdfNum8().buildRequest("<UDFNUM08 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM08>");
        String udfNum09 = getUdfNum9() == null ? "" : getUdfNum9().buildRequest("<UDFNUM09 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM09>");
        String udfNum10 = getUdfNum10() == null ? "" : getUdfNum10().buildRequest("<UDFNUM10 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFNUM10>");

        String udfDate01 = getUdfDate1() == null ? "" : getUdfDate1().buildRequest("<UDFDATE01 qualifier=\"ACTEND\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE01>");
        String udfDate02 = getUdfDate2() == null ? "" : getUdfDate2().buildRequest("<UDFDATE02 qualifier=\"ACTEND\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE02>");
        String udfDate03 = getUdfDate3() == null ? "" : getUdfDate3().buildRequest("<UDFDATE03 qualifier=\"ACTEND\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE03>");
        String udfDate04 = getUdfDate4() == null ? "" : getUdfDate4().buildRequest("<UDFDATE04 qualifier=\"ACTEND\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE04>");
        String udfDate05 = getUdfDate5() == null ? "" : getUdfDate5().buildRequest("<UDFDATE05 qualifier=\"ACTEND\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE05>");
        String udfDate06 = getUdfDate6() == null ? "" : getUdfDate6().buildRequest("<UDFDATE06 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE06>");
        String udfDate07 = getUdfDate7() == null ? "" : getUdfDate7().buildRequest("<UDFDATE07 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE07>");
        String udfDate08 = getUdfDate8() == null ? "" : getUdfDate8().buildRequest("<UDFDATE08 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE08>");
        String udfDate09 = getUdfDate9() == null ? "" : getUdfDate9().buildRequest("<UDFDATE09 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE09>");
        String udfDate10 = getUdfDate10() == null ? "" : getUdfDate10().buildRequest("<UDFDATE10 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</UDFDATE10>");

        String udfNumsAndDates = udfNum01 + udfNum02 + udfNum03 + udfNum04 + udfNum05 + udfNum06 + udfNum07 + udfNum08 + udfNum09 + udfNum10 + udfDate01 + udfDate02 + udfDate03 + udfDate04 + udfDate05 + udfDate06 + udfDate07 + udfDate08 + udfDate09 + udfDate10;

        String udfChar01 = getUdfChar01() == null || getUdfChar01().isEmpty() ? "" : "<UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar01() + "</UDFCHAR01>";
        String udfChar02 = getUdfChar02() == null || getUdfChar02().isEmpty() ? "" : "<UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar02() + "</UDFCHAR02>";
        String udfChar03 = getUdfChar03() == null || getUdfChar03().isEmpty() ? "" : "<UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar03() + "</UDFCHAR03>";
        String udfChar04 = getUdfChar04() == null || getUdfChar04().isEmpty() ? "" : "<UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar04() + "</UDFCHAR04>";
        String udfChar05 = getUdfChar05() == null || getUdfChar05().isEmpty() ? "" : "<UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar05() + "</UDFCHAR05>";
        String udfChar06 = getUdfChar06() == null || getUdfChar06().isEmpty() ? "" : "<UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar06() + "</UDFCHAR06>";
        String udfChar07 = getUdfChar07() == null || getUdfChar07().isEmpty() ? "" : "<UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar07() + "</UDFCHAR07>";
        String udfChar08 = getUdfChar08() == null || getUdfChar08().isEmpty() ? "" : "<UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar08() + "</UDFCHAR08>";
        String udfChar09 = getUdfChar09() == null || getUdfChar09().isEmpty() ? "" : "<UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar09() + "</UDFCHAR09>";
        String udfChar10 = getUdfChar10() == null || getUdfChar10().isEmpty() ? "" : "<UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar10() + "</UDFCHAR10>";
        String udfChar11 = getUdfChar11() == null || getUdfChar11().isEmpty() ? "" : "<UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar11() + "</UDFCHAR11>";
        String udfChar12 = getUdfChar12() == null || getUdfChar12().isEmpty() ? "" : "<UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar12() + "</UDFCHAR12>";
        String udfChar13 = getUdfChar13() == null || getUdfChar13().isEmpty() ? "" : "<UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar13() + "</UDFCHAR13>";
        String udfChar14 = getUdfChar14() == null || getUdfChar14().isEmpty() ? "" : "<UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar14() + "</UDFCHAR14>";
        String udfChar15 = getUdfChar15() == null || getUdfChar15().isEmpty() ? "" : "<UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar15() + "</UDFCHAR15>";
        String udfChar16 = getUdfChar16() == null || getUdfChar16().isEmpty() ? "" : "<UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar16() + "</UDFCHAR16>";
        String udfChar17 = getUdfChar17() == null || getUdfChar17().isEmpty() ? "" : "<UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar17() + "</UDFCHAR17>";
        String udfChar18 = getUdfChar18() == null || getUdfChar18().isEmpty() ? "" : "<UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar18() + "</UDFCHAR18>";
        String udfChar19 = getUdfChar19() == null || getUdfChar19().isEmpty() ? "" : "<UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar19() + "</UDFCHAR19>";
        String udfChar20 = getUdfChar20() == null || getUdfChar20().isEmpty() ? "" : "<UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar20() + "</UDFCHAR20>";
        String udfChar21 = getUdfChar21() == null || getUdfChar21().isEmpty() ? "" : "<UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar21() + "</UDFCHAR21>";
        String udfChar22 = getUdfChar22() == null || getUdfChar22().isEmpty() ? "" : "<UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar22() + "</UDFCHAR22>";
        String udfChar23 = getUdfChar23() == null || getUdfChar23().isEmpty() ? "" : "<UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar23() + "</UDFCHAR23>";
        String udfChar24 = getUdfChar24() == null || getUdfChar24().isEmpty() ? "" : "<UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar24() + "</UDFCHAR24>";
        String udfChar25 = getUdfChar25() == null || getUdfChar25().isEmpty() ? "" : "<UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar25() + "</UDFCHAR25>";
        String udfChar26 = getUdfChar26() == null || getUdfChar26().isEmpty() ? "" : "<UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar26() + "</UDFCHAR26>";
        String udfChar27 = getUdfChar27() == null || getUdfChar27().isEmpty() ? "" : "<UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar27() + "</UDFCHAR27>";
        String udfChar28 = getUdfChar28() == null || getUdfChar28().isEmpty() ? "" : "<UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar28() + "</UDFCHAR28>";
        String udfChar29 = getUdfChar29() == null || getUdfChar29().isEmpty() ? "" : "<UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar29() + "</UDFCHAR29>";
        String udfChar30 = getUdfChar30() == null || getUdfChar30().isEmpty() ? "" : "<UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar30() + "</UDFCHAR30>";
        String udfChar31 = getUdfChar31() == null || getUdfChar31().isEmpty() ? "" : "<UDFCHAR31 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar31() + "</UDFCHAR31>";
        String udfChar32 = getUdfChar32() == null || getUdfChar32().isEmpty() ? "" : "<UDFCHAR32 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar32() + "</UDFCHAR32>";
        String udfChar33 = getUdfChar33() == null || getUdfChar33().isEmpty() ? "" : "<UDFCHAR33 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar33() + "</UDFCHAR33>";
        String udfChar34 = getUdfChar34() == null || getUdfChar34().isEmpty() ? "" : "<UDFCHAR34 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar34() + "</UDFCHAR34>";
        String udfChar35 = getUdfChar35() == null || getUdfChar35().isEmpty() ? "" : "<UDFCHAR35 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar35() + "</UDFCHAR35>";
        String udfChar36 = getUdfChar36() == null || getUdfChar36().isEmpty() ? "" : "<UDFCHAR36 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar36() + "</UDFCHAR36>";
        String udfChar37 = getUdfChar37() == null || getUdfChar37().isEmpty() ? "" : "<UDFCHAR37 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar37() + "</UDFCHAR37>";
        String udfChar38 = getUdfChar38() == null || getUdfChar38().isEmpty() ? "" : "<UDFCHAR38 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar38() + "</UDFCHAR38>";
        String udfChar39 = getUdfChar39() == null || getUdfChar39().isEmpty() ? "" : "<UDFCHAR39 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar39() + "</UDFCHAR39>";
        String udfChar40 = getUdfChar40() == null || getUdfChar40().isEmpty() ? "" : "<UDFCHAR40 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar40() + "</UDFCHAR40>";
        String udfChar41 = getUdfChar41() == null || getUdfChar41().isEmpty() ? "" : "<UDFCHAR41 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar41() + "</UDFCHAR41>";
        String udfChar42 = getUdfChar42() == null || getUdfChar42().isEmpty() ? "" : "<UDFCHAR42 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar42() + "</UDFCHAR42>";
        String udfChar43 = getUdfChar43() == null || getUdfChar43().isEmpty() ? "" : "<UDFCHAR43 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar43() + "</UDFCHAR43>";
        String udfChar44 = getUdfChar44() == null || getUdfChar44().isEmpty() ? "" : "<UDFCHAR44 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar44() + "</UDFCHAR44>";
        String udfChar45 = getUdfChar45() == null || getUdfChar45().isEmpty() ? "" : "<UDFCHAR45 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChar45() + "</UDFCHAR45>";

        String udfChars = udfChar01 + udfChar02 + udfChar03 + udfChar04 + udfChar05 + udfChar06 + udfChar07 + udfChar08 + udfChar09 + udfChar10 + udfChar11 + udfChar12 + udfChar13 + udfChar14 + udfChar15 + udfChar16 + udfChar17 + udfChar18 + udfChar19 + udfChar20 + udfChar21 + udfChar22 + udfChar23 + udfChar24 + udfChar25 + udfChar26 + udfChar27 + udfChar28 + udfChar29 + udfChar30 + udfChar31 + udfChar32 + udfChar33 + udfChar34 + udfChar35 + udfChar36 + udfChar37 + udfChar38 + udfChar39 + udfChar40 + udfChar41 + udfChar42 + udfChar43 + udfChar44 + udfChar45;

        String udfChkBox01 = getUdfChkBox01() == null || getUdfChkBox01().isEmpty() ? "" : "<UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox01() + "</UDFCHKBOX01>";
        String udfChkBox02 = getUdfChkBox02() == null || getUdfChkBox02().isEmpty() ? "" : "<UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox02() + "</UDFCHKBOX02>";
        String udfChkBox03 = getUdfChkBox03() == null || getUdfChkBox03().isEmpty() ? "" : "<UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox03() + "</UDFCHKBOX03>";
        String udfChkBox04 = getUdfChkBox04() == null || getUdfChkBox04().isEmpty() ? "" : "<UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox04() + "</UDFCHKBOX04>";
        String udfChkBox05 = getUdfChkBox05() == null || getUdfChkBox05().isEmpty() ? "" : "<UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox05() + "</UDFCHKBOX05>";
        String udfChkBox06 = getUdfChkBox06() == null || getUdfChkBox06().isEmpty() ? "" : "<UDFCHKBOX06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox06() + "</UDFCHKBOX06>";
        String udfChkBox07 = getUdfChkBox07() == null || getUdfChkBox07().isEmpty() ? "" : "<UDFCHKBOX07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox07() + "</UDFCHKBOX07>";
        String udfChkBox08 = getUdfChkBox08() == null || getUdfChkBox08().isEmpty() ? "" : "<UDFCHKBOX08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox08() + "</UDFCHKBOX08>";
        String udfChkBox09 = getUdfChkBox09() == null || getUdfChkBox09().isEmpty() ? "" : "<UDFCHKBOX09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox09() + "</UDFCHKBOX09>";
        String udfChkBox10 = getUdfChkBox10() == null || getUdfChkBox10().isEmpty() ? "" : "<UDFCHKBOX10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfChkBox10() + "</UDFCHKBOX10>";

        String udfCheckBoxes =  udfChkBox01 + udfChkBox02 + udfChkBox03 + udfChkBox04 + udfChkBox05 + udfChkBox06 + udfChkBox07 + udfChkBox08 + udfChkBox09 + udfChkBox10;

        String udfNote01 = getUdfNote01() == null || getUdfNote01().isEmpty() ? "" : "<UDFNOTE01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfNote01() + "</UDFNOTE01>";
        String udfNote02 = getUdfNote02() == null || getUdfNote02().isEmpty() ? "" : "<UDFNOTE02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + getUdfNote02() + "</UDFNOTE02>";

        String udfNotes = udfNote01 + udfNote02;

        return upper + udfChars + udfNumsAndDates + udfCheckBoxes + udfNotes + lower;
    }
}
