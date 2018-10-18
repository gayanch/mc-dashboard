/*
 * An XML document type.
 * Localname: setTaskStartDeadlineExpression
 * Namespace: http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803
 * Java type: org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument
 *
 * Automatically generated - do not modify.
 */
package org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.impl;
/**
 * A document containing one setTaskStartDeadlineExpression(@http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803) element.
 *
 * This is a complex type.
 */
public class SetTaskStartDeadlineExpressionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument
{
    private static final long serialVersionUID = 1L;
    
    public SetTaskStartDeadlineExpressionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SETTASKSTARTDEADLINEEXPRESSION$0 = 
        new javax.xml.namespace.QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803", "setTaskStartDeadlineExpression");
    
    
    /**
     * Gets the "setTaskStartDeadlineExpression" element
     */
    public org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression getSetTaskStartDeadlineExpression()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression target = null;
            target = (org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression)get_store().find_element_user(SETTASKSTARTDEADLINEEXPRESSION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "setTaskStartDeadlineExpression" element
     */
    public void setSetTaskStartDeadlineExpression(org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression setTaskStartDeadlineExpression)
    {
        generatedSetterHelperImpl(setTaskStartDeadlineExpression, SETTASKSTARTDEADLINEEXPRESSION$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "setTaskStartDeadlineExpression" element
     */
    public org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression addNewSetTaskStartDeadlineExpression()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression target = null;
            target = (org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression)get_store().add_element_user(SETTASKSTARTDEADLINEEXPRESSION$0);
            return target;
        }
    }
    /**
     * An XML setTaskStartDeadlineExpression(@http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803).
     *
     * This is a complex type.
     */
    public static class SetTaskStartDeadlineExpressionImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SetTaskStartDeadlineExpressionDocument.SetTaskStartDeadlineExpression
    {
        private static final long serialVersionUID = 1L;
        
        public SetTaskStartDeadlineExpressionImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDENTIFIER$0 = 
            new javax.xml.namespace.QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803", "identifier");
        private static final javax.xml.namespace.QName DEADLINENAME$2 = 
            new javax.xml.namespace.QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803", "deadlineName");
        private static final javax.xml.namespace.QName DEADLINEEXPRESSION$4 = 
            new javax.xml.namespace.QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803", "deadlineExpression");
        
        
        /**
         * Gets the "identifier" element
         */
        public java.lang.String getIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "identifier" element
         */
        public org.apache.xmlbeans.XmlAnyURI xgetIdentifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(IDENTIFIER$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "identifier" element
         */
        public void setIdentifier(java.lang.String identifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IDENTIFIER$0);
                }
                target.setStringValue(identifier);
            }
        }
        
        /**
         * Sets (as xml) the "identifier" element
         */
        public void xsetIdentifier(org.apache.xmlbeans.XmlAnyURI identifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(IDENTIFIER$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(IDENTIFIER$0);
                }
                target.set(identifier);
            }
        }
        
        /**
         * Gets the "deadlineName" element
         */
        public java.lang.String getDeadlineName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEADLINENAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "deadlineName" element
         */
        public org.apache.xmlbeans.XmlNCName xgetDeadlineName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlNCName target = null;
                target = (org.apache.xmlbeans.XmlNCName)get_store().find_element_user(DEADLINENAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "deadlineName" element
         */
        public void setDeadlineName(java.lang.String deadlineName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEADLINENAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEADLINENAME$2);
                }
                target.setStringValue(deadlineName);
            }
        }
        
        /**
         * Sets (as xml) the "deadlineName" element
         */
        public void xsetDeadlineName(org.apache.xmlbeans.XmlNCName deadlineName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlNCName target = null;
                target = (org.apache.xmlbeans.XmlNCName)get_store().find_element_user(DEADLINENAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlNCName)get_store().add_element_user(DEADLINENAME$2);
                }
                target.set(deadlineName);
            }
        }
        
        /**
         * Gets the "deadlineExpression" element
         */
        public java.lang.String getDeadlineExpression()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEADLINEEXPRESSION$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "deadlineExpression" element
         */
        public org.apache.xmlbeans.XmlString xgetDeadlineExpression()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEADLINEEXPRESSION$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "deadlineExpression" element
         */
        public void setDeadlineExpression(java.lang.String deadlineExpression)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEADLINEEXPRESSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEADLINEEXPRESSION$4);
                }
                target.setStringValue(deadlineExpression);
            }
        }
        
        /**
         * Sets (as xml) the "deadlineExpression" element
         */
        public void xsetDeadlineExpression(org.apache.xmlbeans.XmlString deadlineExpression)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEADLINEEXPRESSION$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DEADLINEEXPRESSION$4);
                }
                target.set(deadlineExpression);
            }
        }
    }
}
