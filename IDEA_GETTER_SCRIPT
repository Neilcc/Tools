public ##
#if($field.modifierStatic)
  static ##
#end
$field.type ##
#set($name = $StringUtil.capitalizeWithJavaBeanConvention($StringUtil.sanitizeJavaIdentifier($helper.getPropertyName($field, $project))))
#if ($field.boolean && $field.primitive)
  #if ($StringUtil.startsWithIgnoreCase($name, 'is'))
    #set($name = $StringUtil.decapitalize($name))
  #else
    is##
#end
#else
  get##
#end
${name}() {
#if($field.String)
  return android.text.TextUtils.isEmpty($field.name) ? "" : $field.name;
#else
  #if ($field.List || $field.ArrayList)
      if($field.name == null){
        $field.name = new java.util.ArrayList<>();
      }
  #else
      #if (!$field.primitive)
        if($field.name == null){
           $field.name = new $field.type ();
        }  
      #end
  #end
  return $field.name;
#end
}
