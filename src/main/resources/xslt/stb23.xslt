<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<xsl:output method="html" indent="yes" encoding="UTF-8"/>
<xsl:template name="main" match="/">
  <xsl:element name="html">
  	<xsl:element name="head">
	  	<xsl:element name="title">Ok</xsl:element>
  	</xsl:element>
		<xsl:element name="body">
	    	<xsl:element name="h2"><xsl:value-of select="stb/title"/></xsl:element>
	    	<xsl:element name="p">(V
	    		<xsl:value-of select="stb/version"/> - 
	    		<xsl:value-of select="stb/date"/>
	    		)
	    	</xsl:element>
	    	<xsl:element name="p"><xsl:value-of select="stb/description"/></xsl:element>
	    
	    	<xsl:call-template name="client"/>
	    	<xsl:call-template name="team"/>
	    	<xsl:call-template name="features"/>
	    
	   	</xsl:element>
   </xsl:element>
</xsl:template>

<xsl:template name="client">
	<xsl:element name="h2">Client : <xsl:value-of select="stb/client/entity"/></xsl:element>
    <xsl:element name="p">
    	Interlocuteur : <xsl:value-of select="stb/client/person"/>
    	Tel(s) : 
    	<xsl:for-each select="stb/client/tel">
    		<xsl:value-of select="."/>
    		<xsl:text> </xsl:text>
    	</xsl:for-each>
    	Mail(s) : 
    	<xsl:for-each select="stb/client/mail">
    		<xsl:value-of select="."/>
    		<xsl:text> </xsl:text>
    	</xsl:for-each>
    </xsl:element>
</xsl:template>

<xsl:template name="team">
	<xsl:element name="h2">Equipe :</xsl:element>
    <xsl:element name="ul">
    	<xsl:for-each select="stb/team/member">
	    	<xsl:element name="li">
	    		<xsl:value-of select="person/@gender"/>
	    		<xsl:text> </xsl:text>
		    	<xsl:value-of select="person"/>
		    	<xsl:text> </xsl:text>
		    	<xsl:value-of select="person/@lastname"/>
		    	<xsl:text>, </xsl:text>
		    	<xsl:value-of select="function"/>
		    	<xsl:text> (</xsl:text>
		    	<xsl:value-of select="mail"/>
		    	<xsl:text>)</xsl:text>
	    	</xsl:element>
    	</xsl:for-each>
    </xsl:element>
</xsl:template>

<xsl:template name="features">
	<xsl:element name="h2">Liste des fonctionnalités :</xsl:element>
    <xsl:element name="table">
    	<xsl:for-each select="stb/features/feature">
    		<xsl:element name="tr">
    			<xsl:element name="td">item=<xsl:value-of select="@number"/><xsl:text>.</xsl:text><xsl:value-of select="@section"/></xsl:element>
    			<xsl:element name="td"><xsl:value-of select="@name"/></xsl:element>
    		</xsl:element>
			
			<xsl:element name="tr">
				<xsl:element name="td">priorité : <xsl:value-of select="priority"/></xsl:element>
				<xsl:element name="td">Livraison : <xsl:value-of select="delivery"/></xsl:element>
			</xsl:element>
			
			<xsl:element name="tr">
				<xsl:element name="td">
					<xsl:value-of select="description"/>
					<xsl:element name="br"/>
					<xsl:value-of select="comment"/>
				</xsl:element>
			</xsl:element>
			
			<xsl:element name="tr">
				<xsl:element name="td">
					<xsl:element name="br"/>
				</xsl:element>
			</xsl:element>

    	</xsl:for-each>
    </xsl:element>
</xsl:template>

</xsl:stylesheet> 