package com.example

import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.engine.AttributeName
import org.thymeleaf.model.IProcessableElementTag
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor
import org.thymeleaf.processor.element.IElementTagStructureHandler
import org.thymeleaf.templatemode.TemplateMode
import org.unbescape.html.HtmlEscape

class SayToAttributeTagProcessor(dialectPrefix: String) : AbstractAttributeTagProcessor(
    TemplateMode.HTML,
    dialectPrefix,
    null,
    false,
    ATTR_NAME,
    true,
    PRECEDENCE,
    true
) {
    companion object {
        private const val ATTR_NAME = "sayto"
        private const val PRECEDENCE = 10000
    }

    override fun doProcess(
        context: ITemplateContext?,
        tag: IProcessableElementTag?,
        attributeName: AttributeName?,
        attributeValue: String?,
        structureHandler: IElementTagStructureHandler?) {
        structureHandler?.setBody(
            "Hello, " + HtmlEscape.escapeHtml5(attributeValue) + "!", false)
    }
}