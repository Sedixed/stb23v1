<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    <xsl:output method="html" indent="yes" encoding="UTF-8"/>
    <xsl:template name="main" match="/">
        <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
        <xsl:element name="html">
            <xsl:element name="head">
                <xsl:element name="title">STB23 - Error</xsl:element>
            </xsl:element>
            <xsl:element name="body">
                <xsl:element name="h1">STB23 ID : <xsl:value-of select="result/id"/></xsl:element>
                <xsl:element name="h2">Status : <xsl:value-of select="result/status"/></xsl:element>
            </xsl:element>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>