<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<xsl:output method="html" indent="yes" encoding="UTF-8"/>

<xsl:template name="main" match="/">
	<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
  	<xsl:element name="html">

  		<xsl:element name="head">
	  		<xsl:element name="title">STB23</xsl:element>
  		</xsl:element>

		<xsl:element name="body">
	    	<xsl:element name="h1"><xsl:value-of select="stb/title"/></xsl:element>
	    	<xsl:element name="h2">
				V<xsl:value-of select="stb/version"/> - <xsl:value-of select="stb/date"/>
	    	</xsl:element>
	    	<xsl:element name="p"><xsl:value-of select="stb/description"/></xsl:element>

			<xsl:element name="hr"/>
	    
	    	<xsl:call-template name="client"/>
			<xsl:element name="hr"/>
	    	<xsl:call-template name="team"/>
			<xsl:element name="hr"/>
	    	<xsl:call-template name="features"/>
	    
	   	</xsl:element>
   </xsl:element>
</xsl:template>

<xsl:template name="client">
	<xsl:element name="h2">Client : <xsl:value-of select="stb/client/entity"/></xsl:element>
    <xsl:element name="p">Interlocutor : <xsl:value-of select="stb/client/person"/></xsl:element>
	<xsl:element name="p">Tel(s) :</xsl:element>
	<xsl:element name="ul">
    	<xsl:for-each select="stb/client/tel">
			<xsl:element name="li"><xsl:value-of select="."/></xsl:element>
		</xsl:for-each>
	</xsl:element>
	<xsl:element name="p">Mail(s) :</xsl:element>
	<xsl:element name="ul">
		<xsl:for-each select="stb/client/mail">
			<xsl:element name="li"><xsl:value-of select="."/></xsl:element>
		</xsl:for-each>
	</xsl:element>
</xsl:template>

<xsl:template name="team">
	<xsl:element name="h2">Team :</xsl:element>
    <xsl:element name="ul">
    	<xsl:for-each select="stb/team/member">
	    	<xsl:element name="li">
	    		<xsl:value-of select="person/@gender"/>
	    		<xsl:text> </xsl:text>
		    	<xsl:value-of select="person"/>
		    	<xsl:text> </xsl:text>
		    	<xsl:value-of select="person/@lastname"/>
				<xsl:element name="p">Mail : <xsl:value-of select="mail"/></xsl:element>
				<xsl:element name="p">Functions :</xsl:element>
				<xsl:element name="ul">
					<xsl:for-each select="function">
						<xsl:element name="li"><xsl:value-of select="."/></xsl:element>
					</xsl:for-each>
				</xsl:element>
	    	</xsl:element>
			<xsl:element name="br"/>
    	</xsl:for-each>
    </xsl:element>
</xsl:template>

<xsl:template name="features">
	<xsl:element name="h2">Features list :</xsl:element>
    <xsl:element name="table">
		<xsl:element name="tr">
			<xsl:element name="th">Name</xsl:element>
			<xsl:element name="th">Section and number</xsl:element>
			<xsl:element name="th">Description</xsl:element>
			<xsl:element name="th">Priority</xsl:element>
			<xsl:element name="th">Delivery date</xsl:element>
			<xsl:element name="th">Comment</xsl:element>
		</xsl:element>
    	<xsl:for-each select="stb/features/feature">
			<xsl:element name="tr">
				<xsl:element name="td"><xsl:value-of select="@name"/></xsl:element>
				<xsl:element name="td"><xsl:value-of select="@section"/>.<xsl:value-of select="@number"/></xsl:element>
				<xsl:element name="td"><xsl:value-of select="description"/></xsl:element>
				<xsl:element name="td"><xsl:value-of select="priority"/></xsl:element>
				<xsl:element name="td"><xsl:value-of select="delivery"/></xsl:element>
				<xsl:element name="td"><xsl:value-of select="comment"/></xsl:element>
			</xsl:element>
		</xsl:for-each>
    </xsl:element>
</xsl:template>

</xsl:stylesheet> 