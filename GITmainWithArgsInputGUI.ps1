Add-Type -AssemblyName System.Windows.Forms
Add-Type -AssemblyName System.Drawing
 
$PowerShellForms = New-Object System.Windows.Forms.Form 
$PowerShellForms.Text = "The Second form"
$PowerShellForms.Size = New-Object System.Drawing.Size(300,300) 
$PowerShellForms.StartPosition = "CenterScreen"
$PowerShellForms.SizeGripStyle = "Hide"
 
$OKButton = New-Object System.Windows.Forms.Button
$OKButton.Location = New-Object System.Drawing.Point(75,160)
$OKButton.Size = New-Object System.Drawing.Size(75,23)
$OKButton.Text = "确定"
$OKButton.DialogResult = [System.Windows.Forms.DialogResult]::OK
$PowerShellForms.AcceptButton = $OKButton
$PowerShellForms.Controls.Add($OKButton)
 
$Labels1 = New-Object System.Windows.Forms.Label
$Labels1.Location = New-Object System.Drawing.Point(10,20) 
$Labels1.Size = New-Object System.Drawing.Size(280,20) 
$Labels1.Text = "请输入你的commit备注信息:"
$Labels1.AutoSize = $True
$PowerShellForms.Controls.Add($Labels1) 
 
$TextBox1 = New-Object System.Windows.Forms.TextBox 
$TextBox1.Location = New-Object System.Drawing.Point(10,50) 
$TextBox1.Size = New-Object System.Drawing.Size(260,20) 
$PowerShellForms.Controls.Add($TextBox1) 

$PowerShellForms.Topmost = $True
 
$result = $PowerShellForms.ShowDialog()

Write-Output "================开始执行命令==================="
git status

Write-Output "git add ."
git add .

Write-Output "git commit ..."
git commit -m $TextBox1.Text

Write-Output "git push"
git push
Write-Output "================结束命令执行==================="
pause
