.section data

numAsc:
.long 48
.long 57


.text
.align

.global _isNumber:
_isNumber:
  push    %ebp
  movl    %esp, %ebp
  lea     8(%ebp), (%eax)
  leave
  ret

  

