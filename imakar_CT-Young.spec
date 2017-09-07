# -*- mode: python -*-

block_cipher = None


a = Analysis(['iMakar_CT-Young.py'],
             pathex=['E:\\Python\\cmu_ctyoung'],
             binaries=[],
             datas=[('network.ico', '.')],
             hiddenimports=[],
             hookspath=[],
             runtime_hooks=[],
             excludes=[],
             win_no_prefer_redirects=False,
             win_private_assemblies=False,
             cipher=block_cipher)
pyz = PYZ(a.pure, a.zipped_data,
             cipher=block_cipher)
exe = EXE(pyz,
          a.scripts,
          exclude_binaries=True,
          name='iMakar_CT-Young',
          debug=False,
          strip=False,
          upx=True,
          console=False , icon='network.ico')
coll = COLLECT(exe,
               a.binaries,
               a.zipfiles,
               a.datas,
               strip=False,
               upx=True,
               name='iMakar_CT-Young')
