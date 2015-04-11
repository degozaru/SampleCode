.global _addLargeNumbers
_addLargeNumbers:

//ESI = numbers 1
//EBX = numbers 2
//EDI = RESULT
//EDX = numbers 1 last index
//EAX = numbers 2 last index
//ECX = result last index
push	%ebp
movl	%esp, %ebp
movl	8(%ebp), %esi
movl 	12(%ebp), %ebx
//This section gets the string length and verifies that
//the string is a number.
pushl	%esi
call 	_strLen
pushl	%eax
call	_verifyString
cmp 	$0, %eax
je 		notNum
popl 	%edx
addl 	$4, %esp

pushl 	%ebx
call	_strLen
pushl	%eax
call	_verifyString
cmp 	$0, %eax
je 		notNum
popl 	%ecx
addl 	$4, %esp

//This will compare the strings
//copies the larger string to the result
//After this, ebx will be the adder string.
movl 	16(%ebp), %edi
cmp 	%edx, %ecx
jg		bGreater
xchg	%edx, %ecx
jmp 	cpy
bGreater:
xchg	%esi, %ebx
cpy:
pushl	%edx
pushl	%edi
pushl	%esi
pushl	%ecx
call	_cpyStr
popl	%ecx
addl	$4, %esp
popl	%edi
popl	%edx
movl	%ebx, %esi

//This will iterate through the arrays and add
//the numbers.
pushl	%edx
addLoop:
cmp		$0, %edx
jl		postProcess
movb	(%esi, %edx, 1), %al
movb	(%edi, %ecx, 1), %ah
addb	%al, %ah
movb	%ah, (%edi, %ecx, 1)
subb	$48, (%edi, %ecx, 1)
dec		%ecx
dec		%edx
jmp		addLoop

postProcess:
popl	%edx
processLoop:
cmp		$0, %edx
je		doneWithEverything
cmpb	$57, (%edi,%edx,1)
jg		overflow
dec		%edx
jmp		processLoop

overflow:
subb	$10, (%edi,%edx,1)
dec		%edx
addb	$1, (%edi,%edx,1)
jmp 	processLoop

notNum:
xorl 	%eax, %eax
doneWithEverything:
movl	%edi, %eax
leave
ret


.global _strLen
_strLen:
push	%ebp
movl	%esp, %ebp
movl 	8(%ebp), %edi
movl 	$256, 	%ecx
movl 	$257, 	%eax
movb 	$0, %al
cld
repne 	scasb
subl 	%ecx, %eax
dec 	%eax
leave
ret


.global _verifyString
_verifyString:
push	%ebp
movl	%esp, %ebp
movl 	8(%ebp), %ecx
movl 	12(%ebp), %edi
xorl 	%eax, %eax
dec 	%ecx
verifyNext:
cmp		$0, %ecx
jl		done
cmpb	$48, (%edi, %ecx, 1)
jl		notAString
cmpb	$57, (%edi, %ecx, 1)
jg		notAString
dec 	%ecx
jmp		verifyNext
done:
inc 	%eax
notAString:
leave
ret

.global _cpyStr
_cpyStr:
push	%ebp
movl	%esp, %ebp
movl	8(%ebp), %ecx
movl 	12(%ebp), %esi
movl	16(%ebp), %edi
cld
rep movsb
leave
ret


