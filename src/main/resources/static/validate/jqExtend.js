(function (window, undefined) {

    var r20 = /%20/g,
        rbracket = /\[\]$/,
        rCRLF = /\r?\n/g,
        rsubmitterTypes = /^(?:submit|button|image|reset|file)$/i,
        manipulation_rcheckableType = /^(?:checkbox|radio)$/i,
        rsubmittable = /^(?:input|select|textarea|keygen)/i;
    jQuery.fn.extend({
                         //add by li.rui。将form内参数转换为jsonobject。example：$("#form").serializeObject();
                         serializeObject: function () {
                             var a, o, h, i, e;
                             a = this.serializeArray();
                             o = {};
                             h = o.hasOwnProperty;
                             for (i = 0; i < a.length; i++) {
                                 e = a[i];
                                 if (!h.call(o, e.name)) {
                                     o[e.name] = e.value;
                                 }
                             }
                             return o;
                         },
                         serialize: function () {
                             return jQuery.param(this.serializeArray());
                         },
                         serializeArray: function () {
                             return this.map(function () {
                                 // Can add propHook for "elements" to filter or add form elements
                                 var elements = jQuery.prop(this, "elements");
                                 return elements ? jQuery.makeArray(elements) : this;
                             })
                                 .filter(function () {
                                     var type = this.type;
                                     // Use .is(":disabled") so that fieldset[disabled] works
                                     return this.name && !jQuery(this).is(":disabled") &&
                                            rsubmittable.test(this.nodeName)
                                            && !rsubmitterTypes.test(type) &&
                                            ( this.checked || !manipulation_rcheckableType.test(
                                                type) );
                                 })
                                 .map(function (i, elem) {
                                     var val = jQuery(this).val();

                                     return val == null ?
                                            null :
                                            jQuery.isArray(val) ?
                                            jQuery.map(val, function (val) {
                                                return {
                                                    name: elem.name,
                                                    value: val.replace(rCRLF, "\r\n")
                                                };
                                            }) :
                                            {name: elem.name, value: val.replace(rCRLF, "\r\n")};
                                 }).get();
                         }
                     });
})( window );