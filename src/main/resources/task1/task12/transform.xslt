<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates select="RootElement"/>
    </xsl:template>

    <xsl:template match="RootElement">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="Loaners">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>

            <GuarantorDetails>
                <GuarantorName>John Doe</GuarantorName>
                <GuarantorAddress>123 Main St, Springfield</GuarantorAddress>
                <GuarantorPhone>+1234567890</GuarantorPhone>
                <GuarantorRelationship>Friend</GuarantorRelationship>
            </GuarantorDetails>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="@* | node()">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
    </xsl:template>
</xsl:stylesheet>