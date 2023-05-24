<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    <xsl:output method="html" indent="yes" encoding="UTF-8"/>
    <xsl:template name="main" match="/">
        <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
        <xsl:element name="html">
            <xsl:element name="head">
                <xsl:element name="title">STB resume</xsl:element>
            </xsl:element>
            <xsl:element name="body">
                <xsl:element name="table">
                    <xsl:element name="tr">
                        <xsl:element name="th">ID</xsl:element>
                        <xsl:element name="th">Title</xsl:element>
                        <xsl:element name="th">Description</xsl:element>
                        <xsl:element name="th">Date</xsl:element>
                        <xsl:element name="th">Client entity name</xsl:element>
                    </xsl:element>
                    <xsl:for-each select="result/stb">
                        <xsl:element name="tr">
                            <xsl:element name="td"><xsl:value-of select="id"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="title"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="description"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="date"/></xsl:element>
                            <xsl:element name="td"><xsl:value-of select="clientEntity"/></xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
            </xsl:element>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>