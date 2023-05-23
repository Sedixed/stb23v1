<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

    <xsl:output method="html" indent="yes" encoding="UTF-8"/>

    <xsl:template name="main" match="/">
        <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
        <xsl:element name="html">
            <xsl:element name="head">
                <xsl:element name="title">STB </xsl:element>
            </xsl:element>
            <xsl:element name="body">

            <xsl:for-each select="result/stb">

                <xsl:text> </xsl:text>
                <xsl:value-of select="id"/>
            </xsl:for-each>
            </xsl:element>
        </xsl:element>
    </xsl:template>



</xsl:stylesheet>