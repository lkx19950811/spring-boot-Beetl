selectUsers
===
* 注释

	select #use("cols")# from user  where  #use("condition")#

cols
===
	id,name,age,userName,roleId,date

updateSample
===
	
	id=#id#,name=#name#,age=#age#,userName=#userName#,roleId=#roleId#,date=#date#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(age)){
	 and age=#age#
	@}
	@if(!isEmpty(userName)){
	 and userName=#userName#
	@}
	@if(!isEmpty(roleId)){
	 and roleId=#roleId#
	@}
	@if(!isEmpty(date)){
	 and date=#date#
	@}
	